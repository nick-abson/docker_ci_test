package gb.nabson.taxonomyapi.service;

import gb.nabson.taxonomyapi.model.Subclass;
import gb.nabson.taxonomyapi.persistance.repository.SubclassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubclassService {
    private SubclassRepository subclassRepository;

    @Autowired  // inject @Primary implementation
    public SubclassService(SubclassRepository subclassRepository) {
        this.subclassRepository = subclassRepository;
    }

    public Iterable<Subclass> getAllSubclasses(String divisionId) {
        return subclassRepository.findAll(divisionId);
    }

    public Subclass getSubclassById(String id) {
        return subclassRepository.findById(id);
    }

    public void saveSubclass(Subclass subclass) {
        subclassRepository.save(subclass);
    }

    public void deleteSubclassById(String id) {
        subclassRepository.deleteById(id);
    }

}
