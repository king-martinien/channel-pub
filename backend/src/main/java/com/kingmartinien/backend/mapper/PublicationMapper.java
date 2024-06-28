package com.kingmartinien.backend.mapper;

import com.kingmartinien.backend.dto.PublicationDto;
import com.kingmartinien.backend.entity.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PublicationMapper {

    PublicationDto toDto(Publication publication);

    List<PublicationDto> toDto(List<Publication> publications);

    Publication toEntity(PublicationDto publicationDto);

    List<Publication> toEntity(List<PublicationDto> publicationDtos);

}
