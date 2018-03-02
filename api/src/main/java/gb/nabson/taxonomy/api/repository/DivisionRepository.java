package gb.nabson.taxonomy.api.repository;


import gb.nabson.taxonomy.api.model.Division;

import java.util.List;

public interface DivisionRepository {
    List<Division> findAll();
    Division findById(String id);
    void save(Division division);
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
