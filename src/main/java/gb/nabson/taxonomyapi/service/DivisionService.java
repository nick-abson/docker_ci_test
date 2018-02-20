package gb.nabson.taxonomyapi.service;

import gb.nabson.taxonomyapi.model.Division;
import gb.nabson.taxonomyapi.persistance.repository.DivisionRepository;
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
}
