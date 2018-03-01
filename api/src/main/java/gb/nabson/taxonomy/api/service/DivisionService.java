package gb.nabson.taxonomy.api.service;

import gb.nabson.taxonomy.api.repository.DivisionRepository;
import gb.nabson.taxonomy.api.model.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {
    private DivisionRepository divisionRepository;

    @Autowired  // inject @Primary implemenation
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Iterable<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    public Division getDivisionById(String id) {
        return divisionRepository.findById(id);
    }

    public void saveDivision(Division division) {

        divisionRepository.save(division);
    }

    public void deleteDivisionById(String id) {
        divisionRepository.deleteById(id);
    }

    public boolean checkDivisionExistsById(String id) {
        return divisionRepository.existsById(id);
    }

    public long countDivisions(){
        return divisionRepository.count();
    }
}
