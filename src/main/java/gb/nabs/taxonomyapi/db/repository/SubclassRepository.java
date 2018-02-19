package gb.nabs.taxonomyapi.db.repository;

import gb.nabs.taxonomyapi.db.model.Subclass;

public interface SubclassRepository {
    Iterable<Subclass> findAll(String divisionId);
    Subclass findById(String id);
    void save(Subclass subclass);
    void deleteById(String id);
}
