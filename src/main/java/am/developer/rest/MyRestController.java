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
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @RestController is a convenience annotation that does nothing more than adding the @Controller and @ResponseBody annotations.
 * @author haykh
 */
@RestController
@RequestMapping("/barev")
public class MyRestController {
    
    @Autowired
    MyMongoService myMongoService;
    
//Spring lets you return data directly from the controller, without looking for a view, using the @ResponseBody annotation on a method
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable String name) {
        String result = "uraaaa Hello " + name;
        myMongoService.getNames();
        return result;
    }
}
