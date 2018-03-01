package gb.nabson.taxonomy.api.model;



public class Subclass {
    private String id;
    private Division division;
    private String name;
    private String description;

    public Subclass(String id, String name, String description, Division division) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.division = division;
    }

    public Subclass()
    {

    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
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
