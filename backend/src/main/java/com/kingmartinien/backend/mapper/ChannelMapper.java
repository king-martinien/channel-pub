package com.kingmartinien.backend.mapper;

import com.kingmartinien.backend.dto.ChannelDto;
import com.kingmartinien.backend.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChannelMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "version", ignore = true)
    Channel toEntity(ChannelDto channelDto);

    ChannelDto toDto(Channel channel);

    List<ChannelDto> toDto(List<Channel> channelList);

}
