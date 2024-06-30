package com.kingmartinien.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalLinkDto {

    private String id;

    @NotNull(message = "Url is required")
    @NotBlank(message = "Url is required")
    private String url;

}
