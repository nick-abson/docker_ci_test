package gb.nabs.taxonomyapi.db.repository;

import gb.nabs.taxonomyapi.db.model.Division;

public interface DivisionRepository {
    Iterable<Division> findAll();
    Division findById(String id);
    void save(Division division);
    void deleteById(String id);
    boolean existsById(String id);
}
