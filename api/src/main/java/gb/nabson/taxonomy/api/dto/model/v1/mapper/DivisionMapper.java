package gb.nabson.taxonomy.api.dto.model.v1.mapper;

import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.model.Division;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DivisionMapper {

    DivisionMapper INSTANCE = Mappers.getMapper(DivisionMapper.class);

    DivisionDTO divisionToDivisionDTO(Division division);
    Division divisionDtoToDivision(DivisionDTO divisionDTO);

}
