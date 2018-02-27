package gb.nabson.taxonomyapi.persistance.repository;

import gb.nabson.taxonomyapi.model.Division;

public interface DivisionRepository {
    Iterable<Division> findAll();
    Division findById(String id);
    void save(Division division);
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
