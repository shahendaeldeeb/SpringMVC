package spitter.web.tests.controllersTest;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spitter.web.controllers.HomeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController homecontroller = new HomeController();
        MockMvc mockMvc = standaloneSetup(homecontroller).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }
}
