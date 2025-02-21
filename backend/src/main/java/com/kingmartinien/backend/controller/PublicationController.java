package com.kingmartinien.backend.controller;

import com.kingmartinien.backend.dto.PublicationDto;
import com.kingmartinien.backend.mapper.PublicationMapper;
import com.kingmartinien.backend.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publications")
@RequiredArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;
    private final PublicationMapper publicationMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PublicationDto> getAllPublications() {
        return this.publicationMapper.toDto(this.publicationService.getAllPublications());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublicationDto getPublicationById(@PathVariable Long id) {
        return this.publicationMapper.toDto(this.publicationService.getPublicationById(id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePublication(@PathVariable Long id) {
        this.publicationService.deletePublication(id);
    }

}
