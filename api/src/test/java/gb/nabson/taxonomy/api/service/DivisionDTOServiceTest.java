package gb.nabson.taxonomy.api.service;

import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.repository.DivisionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DivisionDTOServiceTest {
    /*
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

        DivisionDTO divisionDTO = new DivisionDTO();
        HashSet divisionData = new HashSet();
        divisionData.add(divisionDTO);

        when(divisionService.getAllDivisions()).thenReturn(divisionData);
        when(divisionService.countDivisions()).thenReturn(1L);

        Iterable<DivisionDTO> divisions = divisionService.getAllDivisions();

        assertEquals(divisionService.countDivisions(),1 );

        verify(divisionRepository, times(1)).count();
        verify(divisionRepository, times(1)).findAll();
    }



*/

}