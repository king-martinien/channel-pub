package com.kingmartinien.backend.mapper;

import com.kingmartinien.backend.dto.PublicationDto;
import com.kingmartinien.backend.entity.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PublicationMapper {

    PublicationDto toDto(Publication publication);

    List<PublicationDto> toDto(List<Publication> publications);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    Publication toEntity(PublicationDto publicationDto);

}
