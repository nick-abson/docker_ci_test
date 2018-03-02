package gb.nabson.taxonomy.api.repository;

import gb.nabson.taxonomy.api.bootstrap.TestData;
import gb.nabson.taxonomy.api.dto.model.v1.mapper.DivisionMapper;
import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.model.Division;
import gb.nabson.taxonomy.api.service.DivisionService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@ActiveProfiles("qa")
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Transactional // rollback
@AutoConfigureTestDatabase(replace = NONE) // use a real database for the test
public class DivisionServiceIT {

    @Autowired
    DivisionRepository divisionRepository;

    @Autowired
    SubclassRepository subclassRepository;

    DivisionService divisionService;

    @Before
    public void setUp() throws Exception {
        System.out.println("Loading test data");
        System.out.println(divisionRepository.findAll().size());


        TestData testData = new TestData(divisionRepository, subclassRepository);

        testData.loadItData();

        divisionService = new DivisionService(divisionRepository ,DivisionMapper.INSTANCE);
//        divisionRepository.findAll().forEach(division -> System.out.println(division.getName()));
    }

    @Test
    public void putDivision() throws Exception {
        String updatedDescripion = "Updated Description";
        String testId = getDivisionId();

        Division division = divisionRepository.findById(testId);
        assertNotNull(division);

        String originalDescription =division.getDescription();

        // use DTO with the service
        DivisionDTO divisionDTO = new DivisionDTO();

        divisionDTO.setId(testId);
        divisionDTO.setDescription(updatedDescripion);

        divisionService.saveDivision(divisionDTO);

        Division updatedDivision = divisionRepository.findById(testId);

        assertNotNull(updatedDivision);

        String n = updatedDivision.getDescription();
        System.out.println(updatedDescripion +" "+ n);
        assertEquals(updatedDescripion, updatedDivision.getDescription());
        assertNotEquals(originalDescription, updatedDivision.getDescription());


    }
    private String getDivisionId() {
        List<Division> divisions = divisionRepository.findAll();

        return divisions.get(0).getId();
    }
}