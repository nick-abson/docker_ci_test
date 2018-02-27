package gb.nabson.taxonomyapi.service;

import gb.nabson.taxonomyapi.model.Division;
import gb.nabson.taxonomyapi.persistance.repository.DivisionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DivisionServiceTest {
    DivisionService divisionService;
    @Mock
    DivisionRepository divisionRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        divisionService = new DivisionService(divisionRepository);
    }

    @Test
    public void getAllDivisions() {

        Division division = new Division();
        HashSet divisionData = new HashSet();
        divisionData.add(division);

        when(divisionService.getAllDivisions()).thenReturn(divisionData);
        when(divisionService.countDivisions()).thenReturn(1L);

        Iterable<Division> divisions = divisionService.getAllDivisions();

        assertEquals(divisionService.countDivisions(),1 );

        verify(divisionRepository, times(1)).count();
        verify(divisionRepository, times(1)).findAll();
    }





}