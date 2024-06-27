package com.kingmartinien.backend.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDto {

    private Long id;

    private String title;

    private String content;

    private Set<ExternalLinkDto> externalLinks = new HashSet<>();

    private Set<AttachmentDto> attachments = new HashSet<>();

}
