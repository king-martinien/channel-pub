package com.kingmartinien.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDto {

    private Long id;

    @NotEmpty(message = "Publication title is required")
    @NotBlank(message = "Publication title is required")
    private String title;

    @NotEmpty(message = "Publication content is required")
    @NotBlank(message = "Publication content is required")
    private String content;

    @Valid
    private List<ExternalLinkDto> externalLinks;

    @Valid
    private List<AttachmentDto> attachments;

}
