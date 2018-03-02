package gb.nabson.taxonomy.app.api.model;


import java.util.List;

public class DivisionList {
    private List<Division> divisions;

    public DivisionList() {
    }


    public DivisionList(List<Division> divisions) {

        this.divisions = divisions;
    }
    public List<Division> getDivisions() {
        return divisions;
    }

}
