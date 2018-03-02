package gb.nabson.taxonomy.api.dto.model.v1.model;

import java.util.List;
//use to crate 'wrapper' object in json output
public class DivisionListDTO {
    List<DivisionDTO> divisions;

    public DivisionListDTO(List<DivisionDTO> divisions) {
        this.divisions = divisions;
    }

    public List<DivisionDTO> getDivisions() {

        return divisions;
    }

}
