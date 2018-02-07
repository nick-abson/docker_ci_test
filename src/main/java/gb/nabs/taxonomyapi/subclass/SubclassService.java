package gb.nabs.taxonomyapi.subclass;

// in spring a business service is usually a singleton
// when the application it starts a single instance and registers it as a service
// other classes can inject the service - to do this Spring will scan for @Autowired
// when creates an instance of the other class
//

import gb.nabs.taxonomyapi.division.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubclassService {

    // get an instance of the SubclassRepository
    @Autowired
    private SubclassRepository subclassRepository;

    public List<Subclass> getAllSubclasses(String divisionId) {
       return subclassRepository.findSubclassesByDivisionId(divisionId);
    }

    public Subclass getSubclass(String id) {
        return subclassRepository.findOne(id);
    }

    public void addSubclass(String divisionId, Subclass subclass) {

        subclass.setDivision(new Division(divisionId, " "," "));
        subclassRepository.save(subclass);
    }

    public void deleteSubclass(String id) {
        subclassRepository.delete(id);
    }

    // save is add or update
    public void updateSubclass(String id, String divisionId, Subclass subclass) {
        subclass.setId(id);
        subclass.setDivision(new Division(divisionId, " "," "));
        subclassRepository.save(subclass);

    }
}
