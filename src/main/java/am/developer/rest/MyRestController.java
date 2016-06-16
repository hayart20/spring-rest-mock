/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.developer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import am.developer.component.MyMongoService;
import am.developer.entity.Person;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @RestController is a convenience annotation that does nothing more than adding the @Controller and @ResponseBody annotations.
 * @author haykh
 */
@RestController
@RequestMapping("/person")
public class MyRestController {
    
    private final Logger LOG = LoggerFactory.getLogger(MyRestController.class);
    
    @Autowired
    MyMongoService myMongoService;
    
//Spring lets you return data directly from the controller, without looking for a view, using the @ResponseBody annotation on a method
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAll() {
    
        LOG.info("getting all persons with offset: {}, and count: ");

        List<Person> persons = myMongoService.getPersons();

        if (persons == null || persons.isEmpty()){
            LOG.info("no persons found");
            return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
        //return persons;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> personAdd(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("age") int age) {
        LOG.info("creating new person: {}", name, age);
/*
        if (userService.exists(user)){
            LOG.info("a user with name " + user.getUsername() + " already exists");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
*/
        Person personAchilles = new Person();
                personAchilles.setPersonId(id);
                personAchilles.setName(name);
                personAchilles.setAge(age);
        myMongoService.addPerson(personAchilles);

        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
