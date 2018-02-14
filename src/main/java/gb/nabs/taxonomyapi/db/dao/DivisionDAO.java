package gb.nabs.taxonomyapi.db.dao;

import gb.nabs.taxonomyapi.db.model.Division;

import java.util.List;

public interface DivisionDAO {
    List<Division> getAllDivisions();
    Division getDivision(String id);
    void addDivision(Division division);
    void deleteDivision(String id);
    void updateDivision(Division division, String id);
}
