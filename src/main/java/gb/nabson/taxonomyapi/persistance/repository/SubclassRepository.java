package gb.nabson.taxonomyapi.persistance.repository;

import gb.nabson.taxonomyapi.model.Subclass;

public interface SubclassRepository {
    Iterable<Subclass> findAll(String divisionId);
    Subclass findById(String id);
    void save(Subclass subclass);
    void deleteById(String id);
}
