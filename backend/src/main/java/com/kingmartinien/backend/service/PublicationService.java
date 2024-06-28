package com.kingmartinien.backend.service;

import com.kingmartinien.backend.entity.Publication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PublicationService {

    List<Publication> getAllPublications();

    List<Publication> getPublicationsByChannelId(Long channelId);

    Publication getPublicationById(Long id);

    Publication createPublication(Long channelId, Publication publication, MultipartFile file);

    void deletePublication(Long id);

}
