package gb.nabson.taxonomy.api.repository;


import gb.nabson.taxonomy.api.model.Subclass;

import java.util.List;

public interface SubclassRepository {
    List<Subclass> findAll(String divisionId);
    Subclass findById(String id);
    void save(Subclass subclass);
    void deleteById(String id);
    long count(String divisionId);
}
