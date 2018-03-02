package gb.nabson.taxonomy.api.service;

import gb.nabson.taxonomy.api.dto.model.v1.mapper.DivisionMapper;
import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
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
        return divisionMapper.divisionToDivisionDTO( divisionRepository.findById(id));
    }

    public void saveDivision(DivisionDTO divisionDTO) {

        divisionRepository.save(divisionMapper.divisionDtoToDivision(divisionDTO));
    }

    public void deleteDivisionById(String id) {
        divisionRepository.deleteById(id);
    }

}
