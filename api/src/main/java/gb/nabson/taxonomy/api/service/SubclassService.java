package gb.nabson.taxonomy.api.service;

import gb.nabson.taxonomy.api.dto.model.v1.mapper.SubclassMapper;
import gb.nabson.taxonomy.api.dto.model.v1.model.SubclassDTO;
import gb.nabson.taxonomy.api.model.Subclass;
import gb.nabson.taxonomy.api.repository.SubclassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubclassService {
    private SubclassRepository subclassRepository;
    private SubclassMapper subclassMapper;

    @Autowired
    public SubclassService(SubclassRepository subclassRepository, SubclassMapper subclassMapper) {
        this.subclassRepository = subclassRepository;
        this.subclassMapper = subclassMapper;
    }


    public List<SubclassDTO> getAllSubclasses(String divisionId) {
        return subclassRepository.findAll(divisionId)
                .stream()
                .map(subclassMapper::subclassToSubclassDTO)
                .collect(Collectors.toList());
    }

    public SubclassDTO getSubclassById(String id) {
        return  subclassMapper.subclassToSubclassDTO( ( subclassRepository.findById(id)));
    }

    public void saveSubclass(SubclassDTO subclassDTO) {
        subclassRepository.save(subclassMapper.subclassDtoToSubclass( subclassDTO) );
    }

    public void deleteSubclassById(String id) {
                subclassRepository.deleteById(id);
    }

}
