package spitter.web.tests.controllersTest;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spitter.data.SpitterServiceImpl;
import spitter.model.Spitter;
import spitter.web.controllers.SpitterController;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.mockito.Mockito.*;


public class SpitterControllerTest {
    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterServiceImpl spitterServiceImp = mock(SpitterServiceImpl.class);
        SpitterController controller = new SpitterController(spitterServiceImp);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }
    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterServiceImpl spitterServiceImp = mock(SpitterServiceImpl.class);

        Spitter unsaved =
                new Spitter("Jack", "Bauer", "jbauer", "24hours", "");
        Spitter saved =
                new Spitter("Jack1", "Bauer", "jbauer", "24hours", "");

        when(spitterServiceImp.save(unsaved)).thenReturn(saved);
        SpitterController controller =
                new SpitterController(spitterServiceImp);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                        .param("firstName", "Jack")
                        .param("lastName", "Bauer")
                        .param("username", "jbauer")
                        .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));

       // verify(spitterServiceImp, atLeastOnce()).save(unsaved);
    }
}
