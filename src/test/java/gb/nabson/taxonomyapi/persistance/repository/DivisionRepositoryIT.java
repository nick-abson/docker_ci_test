package gb.nabson.taxonomyapi.persistance.repository;

import gb.nabson.taxonomyapi.config.AppConfiguration;
import gb.nabson.taxonomyapi.model.Division;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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