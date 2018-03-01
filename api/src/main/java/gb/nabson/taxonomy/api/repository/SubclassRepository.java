package gb.nabson.taxonomy.api.repository;

import gb.nabson.taxonomy.api.model.Subclass;

public interface SubclassRepository {
    Iterable<Subclass> findAll(String divisionId);
    Subclass findById(String id);
    void save(Subclass subclass);
    void deleteById(String id);
    long count(String divisionId);
}
