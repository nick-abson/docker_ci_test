package gb.nabson.taxonomyapi.web.controller;

import gb.nabson.taxonomyapi.model.Division;
import gb.nabson.taxonomyapi.service.DivisionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class DivisionDisplayControllerTest {

    DivisionDisplayController divisionDisplayController;

    @Mock
    DivisionService divisionService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.divisionDisplayController= new DivisionDisplayController(divisionService);
    }

    @Test
    public void testDisplayAllDivisions() throws Exception {

        HashSet<Division> divisions = new HashSet<>();
        divisions.add(new Division());

        when(divisionService.getAllDivisions()).thenReturn(divisions);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(divisionDisplayController).build();
        mockMvc.perform(get("/divisions/display"))
                .andExpect(status().isOk())
                .andExpect(view().name("divisions/display"))
                .andExpect(model().attributeExists("divisions"));
        verify(divisionService, times(1)).getAllDivisions();
    }
}
