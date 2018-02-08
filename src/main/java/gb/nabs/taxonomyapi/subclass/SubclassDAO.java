package gb.nabs.taxonomyapi.subclass;

import java.util.List;

public interface SubclassDAO {
    List<Subclass> getAllSubclasses(String divisionId);
    Subclass getSubclass(String id);
    void addSubclass(String divisionId, Subclass subclass);
    void deleteSubclass(String id);
    void updateSubclass(String id, String  divisionId, Subclass subclass);
}
