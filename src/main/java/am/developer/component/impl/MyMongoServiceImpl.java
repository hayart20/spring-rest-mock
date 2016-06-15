/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.developer.component.impl;

import am.developer.component.MyMongoService;
import am.developer.entity.Person;
import am.developer.repo.PersonRepo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author haykh
 */
@Service
public class MyMongoServiceImpl implements MyMongoService {

    @Autowired
    PersonRepo personRepo;
    
    @Override
    public void addPerson(Person person) {
        //List<String> results = new ArrayList<>();
	personRepo.save(person);
        //return results;
    }
    
    @Override
    public List<Person> getPersons(){
        List<Person> resultList = new ArrayList<Person>();
        Iterable<Person> all = personRepo.findAll();
        Iterator iterator = all.iterator();
        while (iterator.hasNext()) {
            Person person = (Person) iterator.next ();
            //System.out.println(element);
            resultList.add(person);
        }
        return resultList;
    }
}
