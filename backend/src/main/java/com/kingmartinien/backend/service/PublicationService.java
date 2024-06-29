package com.kingmartinien.backend.service;

import com.kingmartinien.backend.entity.Publication;

import java.util.List;

public interface PublicationService {

    List<Publication> getAllPublications();

    Publication getPublicationById(Long id);

    void deletePublication(Long id);

}
