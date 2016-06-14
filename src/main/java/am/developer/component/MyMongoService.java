/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package am.developer.component;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author haykh
 */
public interface MyMongoService {
    List<String> getNames();
}
