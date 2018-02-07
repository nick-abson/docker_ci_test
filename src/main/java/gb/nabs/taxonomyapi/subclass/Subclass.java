package gb.nabs.taxonomyapi.subclass;


import gb.nabs.taxonomyapi.division.Division;

import javax.persistence.*;

// map objects of this class to a table
// JPA automatically creates a table
// and can convert instances > rows and vice versa.
@Entity
public class Subclass {
    //in JPA pk is marked with Id annotation
    @Id
    private String id;

    // foreign key
    @ManyToOne
    private Division division;
    private String name;
    private String description;

    public Subclass(String id, String name, String description, String divisionId) {
        this.division = new Division(divisionId, " ", " ");
        this.id = id;
        this.name = name;
        this.description = description;
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
