package gb.nabs.taxonomyapi.division;

import java.util.List;

public interface DivisionDAO {
    List<Division> getAllDivisions();
    Division getDivision(String id);
    void addDivision(Division division);
    void deleteDivision(String id);
    void updateDivision(Division division, String id);
}
