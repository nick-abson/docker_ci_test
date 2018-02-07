package gb.nabs.taxonomyapi.division;

// in spring a business service is usually a singleton
// when the application it starts a single instance and registers it as a service
// other classes can inject the service - to do this Spring will scan for @Autowired
// when creates an instance of the other class
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DivisionService {

    // get an instance of the SubclassRepository
    @Autowired
    private DivisionRepository divisionRepository;

    public List<Division> getAllDivisions() {
        // convert iterable to list
        List<Division> divisions = new ArrayList<>();

        divisionRepository.findAll().forEach(divisions::add);
        return divisions;
    }

    public Division getDivision(String id) {
        return divisionRepository.findOne(id);
    }

    public void addDivision(Division division) {

        divisionRepository.save(division);
    }

    public void deleteDivision(String id) {
        divisionRepository.delete(id);
    }

    // save is add or update
    public void updateDivision(Division division, String id) {
        division.setId(id);
        divisionRepository.save(division);
    }
}
