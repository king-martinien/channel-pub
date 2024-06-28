package com.kingmartinien.backend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDto {

    private Long id;

    private String title;

    private String content;

    private List<ExternalLinkDto> externalLinks;

    private List<AttachmentDto> attachments;

}
