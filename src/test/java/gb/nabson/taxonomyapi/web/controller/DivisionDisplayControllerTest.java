package gb.nabson.taxonomyapi.web.controller;

import gb.nabson.taxonomyapi.model.Division;
import gb.nabson.taxonomyapi.service.DivisionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DivisionDisplayControllerTest {
    private DivisionDisplayController divisionDisplayController;

    @Mock
    private DivisionService divisionService;

    @Mock
    private Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.divisionDisplayController= new DivisionDisplayController(divisionService);
    }

    @Test
    public void testDisplayAllDivisions() {
        Division division = new Division();
        //given
        HashSet<Division> divisions = new HashSet<>();
        divisions.add(division);

        when(divisionService.getAllDivisions()).thenReturn(divisions);
        //when
        String displayAllDivisionsPage = divisionDisplayController.displayAllDivisions(model);

        ArgumentCaptor<HashSet> argumentCaptor = ArgumentCaptor.forClass(HashSet.class);

        //then
        verify(model, times(1)).addAttribute(eq("divisions"), argumentCaptor.capture());
        verify(divisionService, times(1)).getAllDivisions();

        //then
        assertEquals(displayAllDivisionsPage, "divisions/display");
        HashSet<Division> setInController = argumentCaptor.getValue();

        assertEquals(setInController.size(), 1);
    }
}