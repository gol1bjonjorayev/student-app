package gol1bjon.developer.springbootapp.mapper;

import gol1bjon.developer.springbootapp.entity.file.FileClass;
import gol1bjon.developer.springbootapp.payload.FileDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    FileDTO toDto(FileClass entity);
}
