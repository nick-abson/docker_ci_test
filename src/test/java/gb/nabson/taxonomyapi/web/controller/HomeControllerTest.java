package gb.nabson.taxonomyapi.web.controller;

import gb.nabson.taxonomyapi.model.Division;
import gb.nabson.taxonomyapi.service.DivisionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest {
    private HomeController  homeController;

    @Mock
    private DivisionService divisionService;

    @Mock
    private Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.homeController= new HomeController(divisionService);
        this.model = model;
    }

    @Test
    public void testGetIndex() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testShowDivisionsOnHomePage() throws Exception {
        Division division = new Division();
        //given
        HashSet<Division> divisions = new HashSet<>();
        divisions.add(division);

        when(divisionService.getAllDivisions()).thenReturn(divisions);
        //when
        String homePage = homeController.home(model);

        ArgumentCaptor<HashSet> argumentCaptor = ArgumentCaptor.forClass(HashSet.class);

        //then
        verify(model,times(1)).addAttribute(eq("divisions"), argumentCaptor.capture());
        verify(divisionService,times(1)).getAllDivisions();

        //then
        assertEquals(homePage, "index");
        HashSet<Division> setInController = argumentCaptor.getValue();

        assertEquals(setInController.size(), 1);
    }
}