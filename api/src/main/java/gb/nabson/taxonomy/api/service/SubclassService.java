package gb.nabson.taxonomy.api.service;

import gb.nabson.taxonomy.api.dto.model.v1.mapper.DivisionMapper;
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
    private DivisionMapper divisionMapper;

    @Autowired
    public SubclassService(SubclassRepository subclassRepository, SubclassMapper subclassMapper, DivisionMapper divisionMapper) {
        this.subclassRepository = subclassRepository;
        this.subclassMapper = subclassMapper;
        this.divisionMapper = divisionMapper;
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

    public void patchSubclass(SubclassDTO subclassDTO) {
        String id = subclassDTO.getId();

        if (id == null)
            return;

        Subclass subclass = subclassRepository.findById(id);

        subclassDTO.setId(id); // note may not exist - save a partial record instead using supplied id instead

        if(subclassDTO.getDescription() == null)
            subclassDTO.setDescription(subclass.getDescription());

        if(subclassDTO.getName() == null)
            subclassDTO.setName(subclass.getName());

        if(subclassDTO.getDivision() == null)
            subclassDTO.setDivision(divisionMapper.divisionToDivisionDTO(subclass.getDivision()));

        subclassRepository.save(subclassMapper.subclassDtoToSubclass( subclassDTO) );
    }
    public void deleteSubclassById(String id) {
                subclassRepository.deleteById(id);
    }

}
