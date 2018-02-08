package gb.nabs.taxonomyapi;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.core.IsEqual.equalTo;


public class TaxonomyApiApplicationTests {

    // sample test to verify JSON GET request using rest-assured
    @Before
    public void init(){
        RestAssured.baseURI = "http://localhost"; // replace as appropriate
        RestAssured.port =   8090;
        System.out.println("debug "+RestAssured.port);
    }

    @Test
    public void testGetDivision() {
        expect().
                statusCode(200).
                body(
                        "id", equalTo("lathyrus"),
                        "name", equalTo("Genus: Lathyrus"),
                        "description", equalTo("vetches")).
                when().
                get("/divisions/lathyrus");
    }

}
