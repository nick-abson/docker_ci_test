package gb.nabson.taxonomy.app.api.model;

import java.util.List;

public class SubclassList {
    List<Subclass> subclasses;

    public SubclassList() {
    }

    public SubclassList(List<Subclass> subclasses) {

        this.subclasses = subclasses;
    }

    public List<Subclass> getSubclasses() {
        return subclasses;
    }

}
