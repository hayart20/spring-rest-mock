/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import am.developer.component.MyMongoService;
import am.developer.rest.MyRestController;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 *
 * @author haykh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/springrest-servlet.xml")
public class MyRestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mockMvc;
    
    MyMongoService service;

    @Before
    public void setup() {
        //The MockMvc will mock all the Spring MVC infrastructure. We just need the Spring application context to create it. 
        this.mockMvc = MockMvcBuilders.webAppContextSetup( this.webApplicationContext ).build();
    }

    @Test @Ignore
    public void addPerson() throws Exception {

            mockMvc.perform(post("/person/hayk/26").accept(MediaType.APPLICATION_JSON))
                .andDo(print()) // print the request/response in the console
                .andExpect(status().isOk());
       
    }
    
    @Test 
    public void getPerson() throws Exception {

            mockMvc.perform(get("/person/all").accept(MediaType.APPLICATION_JSON))
                .andDo(print()) // print the request/response in the console
                .andExpect(status().isOk());
       
    }
    
    @Configuration
    public static class TestConfiguration {
 
        @Bean public MyRestController simpleController() {
            return new MyRestController();
        }
 
    }
}
