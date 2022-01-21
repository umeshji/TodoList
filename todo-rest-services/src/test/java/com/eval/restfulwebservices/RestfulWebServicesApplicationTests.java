package com.eval.restfulwebservices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.eval.restfulwebservices.RestfulWebServicesApplication;
import com.eval.restfulwebservices.basic.auth.BasicAuthenticationController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestfulWebServicesApplication.class})
@WebAppConfiguration
public class RestfulWebServicesApplicationTests {
	
	
	private MockMvc mockMvc;

    @InjectMocks
    private BasicAuthenticationController basicAuthController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(basicAuthController).build();
    }
    
    @Test
    public void givenGreetURI_whenMockMVC_thenVerifyResponse() throws Exception {
        this.mockMvc.perform(get("/basicauth"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.message").value("You are authenticated"))
          .andReturn();
    }
    
    

}
