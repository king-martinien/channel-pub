package com.kingmartinien.backend.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalLinkDto {

    private String id;

    private String url;

}
