package gb.nabson.taxonomy.api.dto.model.v1.model;


public class SubclassDTO {
    private String id;
    private DivisionDTO division;
    private String name;
    private String description;

    public SubclassDTO(String id, String name, String description, DivisionDTO division) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.division = division;
    }

    public SubclassDTO() {}

    public DivisionDTO getDivision() {
        return division;
    }

    public void setDivision(DivisionDTO division) {
        this.division = division;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
