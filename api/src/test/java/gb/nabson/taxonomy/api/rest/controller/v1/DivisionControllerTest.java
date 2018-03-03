package gb.nabson.taxonomy.api.rest.controller.v1;

import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionListDTO;
import gb.nabson.taxonomy.api.service.DivisionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {DivisionController.class})
public class DivisionControllerTest {

    private DivisionDTO divsionDTO1;
    private DivisionDTO divsionDTO2;

    @MockBean
    DivisionService divisionService;

    @InjectMocks
    DivisionController divisionController;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        divsionDTO2 = new DivisionDTO();
        divsionDTO2.setId("a");
        divsionDTO2.setName("a");
        divsionDTO2.setDescription("a");

        divsionDTO1 = new DivisionDTO();
        divsionDTO1.setId("b");
        divsionDTO1.setName("b");
        divsionDTO1.setDescription("b");
    }

    @Test
    public void getAllDivisions() throws Exception{

        DivisionListDTO divisionListDTO = new DivisionListDTO(Arrays.asList(divsionDTO1,divsionDTO2));

        given(divisionService.getAllDivisions()).willReturn(divisionListDTO.getDivisions());

        mockMvc.perform(get("/divisions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.divisions", hasSize(2)));


    }
}