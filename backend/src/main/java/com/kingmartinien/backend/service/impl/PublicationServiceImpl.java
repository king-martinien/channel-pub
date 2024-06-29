package com.kingmartinien.backend.service.impl;

import com.kingmartinien.backend.entity.Publication;
import com.kingmartinien.backend.repository.PublicationRepository;
import com.kingmartinien.backend.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;

    @Override
    public List<Publication> getAllPublications() {
        return this.publicationRepository.findAll();
    }

    @Override
    public Publication getPublicationById(Long id) {
        return this.publicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication not found with id: " + id));
    }

    @Override
    public void deletePublication(Long id) {
        Publication publication = this.getPublicationById(id);
        this.publicationRepository.delete(publication);
    }

}
