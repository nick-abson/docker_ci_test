package gb.nabson.taxonomy.api.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest {
    private HomeController  homeController;

    @Before
    public void setUp() throws Exception {
        this.homeController= new HomeController();
    }

    @Test
    public void testGetIndex() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

}