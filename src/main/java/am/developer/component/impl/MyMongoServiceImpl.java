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

    //@Autowired
    //PersonRepo personRepo;
    
    @Override
    public List<String> getNames() {
        List<String> results = new ArrayList<>();
        System.out.println("am.developer.component.MongoServiceImpl.getNames()");
       /* Person personAchilles = new Person();
				personAchilles.setPersonId(1l);
				personAchilles.setName("Achilles");
				personRepo.save(personAchilles);*/
        System.out.println("ens sss");                                
        return results;
    }
    
}
