package gb.nabson.taxonomy.api.dto.model.v1.model;

import java.util.List;

public class SubclassListDTO {

    List<SubclassDTO> subclasses;

    public List<SubclassDTO> getSubclasses() {
        return subclasses;
    }

    public SubclassListDTO(List<SubclassDTO> subclasses) {
        this.subclasses = subclasses;
    }

}
