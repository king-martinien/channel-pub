package com.kingmartinien.backend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDto {

    private Long id;

    private String name;

    private List<PublicationDto> publications;

}
