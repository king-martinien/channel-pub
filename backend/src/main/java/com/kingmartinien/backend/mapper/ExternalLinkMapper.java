package com.kingmartinien.backend.mapper;

import com.kingmartinien.backend.dto.ExternalLinkDto;
import com.kingmartinien.backend.entity.ExternalLink;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExternalLinkMapper {

    ExternalLink toEntity(ExternalLinkDto externalLinkDto);

    List<ExternalLink> toEntity(List<ExternalLinkDto> externalLinkDtoList);

    ExternalLinkDto toDto(ExternalLink externalLink);

    List<ExternalLinkDto> toDto(List<ExternalLink> externalLinks);

}
