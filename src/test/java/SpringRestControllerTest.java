/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import am.developer.rest.SpringRestController;
import org.junit.Before;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 *
 * @author haykh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/springrest-servlet.xml")
public class SpringRestControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        //The MockMvc will mock all the Spring MVC infrastructure. We just need the Spring application context to create it. 
        this.mockMvc = MockMvcBuilders.webAppContextSetup( this.wac ).build();
    }

    @Test
    public void hello() {
        try{
            mockMvc.perform(get("/barev/hayk").accept(MediaType.APPLICATION_JSON))
                .andDo(print()) // print the request/response in the console
                .andExpect(status().isOk());
        } catch (Exception ex){
            System.out.println("error="+ex);
        }
    }
    
    @Configuration
    public static class TestConfiguration {
 
        @Bean public SpringRestController simpleController() {
            return new SpringRestController();
        }
 
    }
}
