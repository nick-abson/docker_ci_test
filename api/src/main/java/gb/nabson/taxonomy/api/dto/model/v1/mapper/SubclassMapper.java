package gb.nabson.taxonomy.api.dto.model.v1.mapper;

import gb.nabson.taxonomy.api.dto.model.v1.model.SubclassDTO;
import gb.nabson.taxonomy.api.model.Subclass;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubclassMapper {

    SubclassMapper INSTANCE = Mappers.getMapper(SubclassMapper.class);

   SubclassDTO subclassToSubclassDTO(Subclass subclass);
    Subclass subclassDtoToSubclass(SubclassDTO subclassDTO);

}
