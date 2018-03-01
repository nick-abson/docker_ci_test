package gb.nabson.taxonomy.api.repository;

import gb.nabson.taxonomy.api.model.Division;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = { "spring.profiles.active: qa" })
public class DivisionRepositoryIT {

    @Autowired
    DivisionRepository divisionRepository ;

    String id = "test_id_1";
    String name = "test_name_1";
    String description = "test_description_1";

    @Test
    public void testSave() throws Exception {
        Division division = new Division();
        division.setId(id);
        division.setName(name);
        division.setDescription(description);
        divisionRepository.save(division);
        String name = divisionRepository.findById(this.id).getName();
        assertEquals(name , this.name);
        divisionRepository.deleteById(name);
        name = divisionRepository.findById(this.id).getName();
        assertEquals(name , this.name);
    }

}