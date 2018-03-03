package gb.nabson.taxonomy.api.service;

import gb.nabson.taxonomy.api.dto.model.v1.mapper.DivisionMapper;
import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.model.Division;
import gb.nabson.taxonomy.api.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionService {
    private DivisionRepository divisionRepository;
    private DivisionMapper divisionMapper;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    public List<DivisionDTO> getAllDivisions() {
        return divisionRepository.findAll()
                .stream()
                .map(divisionMapper::divisionToDivisionDTO)
                .collect(Collectors.toList());
    }

    public DivisionDTO getDivisionById(String id) {

        return divisionMapper.divisionToDivisionDTO(divisionRepository.findById(id));
    }

    public void saveDivision(DivisionDTO divisionDTO) {
        divisionRepository.save(divisionMapper.divisionDtoToDivision(divisionDTO));
    }

    // patch - only set not null fields
    public void patchDivision(DivisionDTO divisionDTO) {

        String id = divisionDTO.getId();

        if (id == null)
            return;

        Division division = divisionRepository.findById(id);

        divisionDTO.setId(id); // note may not exist - save a partial record instead using supplied id instead

        if (divisionDTO.getDescription() == null)
            divisionDTO.setDescription(division.getDescription());


        if (divisionDTO.getName() == null)
            divisionDTO.setName(division.getName());

        divisionRepository.save(divisionMapper.divisionDtoToDivision(divisionDTO));
    }


    public void deleteDivisionById(String id) {
        divisionRepository.deleteById(id);
    }

}
