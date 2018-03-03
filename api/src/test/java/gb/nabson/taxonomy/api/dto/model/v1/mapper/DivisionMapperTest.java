package gb.nabson.taxonomy.api.dto.model.v1.mapper;

import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.model.Division;
import org.junit.Test;

import static org.junit.Assert.*;


public class DivisionMapperTest {


    DivisionMapper divisionMapper = DivisionMapper.INSTANCE;

    public static final String NAME = "test name";

    @Test
    public void divisionToDivisionDTO() {
        Division division = new Division();
        division.setName(NAME);

        DivisionDTO divisionDTO = divisionMapper.divisionToDivisionDTO(division);

        assertEquals(division.getName(), divisionDTO.getName());

    }

    @Test
    public void divisionDtoToDivision() {
        DivisionDTO divisionDTO = new DivisionDTO();
        divisionDTO.setName(NAME);

        Division division = divisionMapper.divisionDtoToDivision(divisionDTO);

        assertEquals(division.getName(), divisionDTO.getName());
    }
}