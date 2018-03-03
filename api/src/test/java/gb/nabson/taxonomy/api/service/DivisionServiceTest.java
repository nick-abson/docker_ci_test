package gb.nabson.taxonomy.api.service;

import gb.nabson.taxonomy.api.dto.model.v1.mapper.DivisionMapper;
import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.model.Division;
import gb.nabson.taxonomy.api.repository.DivisionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class DivisionServiceTest {
    public static final String ID = "testid1";
    public static final String NAME = "test name 1";
    public static final String DESCRIPTIION = "test description 1";

    DivisionService divisionService;

    @Mock
    DivisionRepository divisionRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        divisionService = new DivisionService(divisionRepository, DivisionMapper.INSTANCE);
    }

    @Test
    public void getAllDivisions() {
        //given
        List<Division> divisions = Arrays.asList(new Division(), new Division(), new Division());

        when(divisionRepository.findAll()).thenReturn(divisions);

        //when
        List<DivisionDTO> divisionDTO = divisionService.getAllDivisions();

        //then
        assertEquals(3, divisionDTO.size());

    }

    @Test
    public void getDivisionById() {

        //given
        Division division = new Division();
        division.setId(ID);
        division.setName(NAME);
        division.setDescription(DESCRIPTIION);

        when(divisionRepository.findById(anyString())).thenReturn(division);


        //when
        DivisionDTO divisionDTO = divisionService.getDivisionById(ID);

        //then
        assertEquals(NAME, divisionDTO.getName());

    }
}
