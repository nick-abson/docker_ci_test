package gb.nabs.taxonomyapi.db.dao;

import gb.nabs.taxonomyapi.db.model.Subclass;

import java.util.List;

public interface SubclassDAO {
    List<Subclass> getAllSubclasses(String divisionId);
    Subclass getSubclass(String id);
    void addSubclass(String divisionId, Subclass subclass);
    void deleteSubclass(String id);
    void updateSubclass(String id, String  divisionId, Subclass subclass);
}
