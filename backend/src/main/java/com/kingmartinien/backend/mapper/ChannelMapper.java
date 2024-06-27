package com.kingmartinien.backend.mapper;

import com.kingmartinien.backend.dto.ChannelDto;
import com.kingmartinien.backend.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChannelMapper {

    Channel toEntity(ChannelDto channelDto);

    ChannelDto toDto(Channel channel);

    List<Channel> toEntity(List<ChannelDto> channelDtoList);

    List<ChannelDto> toDto(List<Channel> channelList);

}
