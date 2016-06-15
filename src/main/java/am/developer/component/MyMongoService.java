/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.developer.component;

import am.developer.entity.Person;
import java.util.List;

/**
 *
 * @author haykh
 */
public interface MyMongoService {
    /**
     * get all person list.
     * @return 
     */
    List<Person> getPersons();
    
    /**
     * add person.
     * @param person
     */
    void addPerson(Person person);
}
