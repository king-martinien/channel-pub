package com.kingmartinien.backend.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentDto {

    private Long id;

    private String fileName;

    private String fileType;

    private String blobId;

}
