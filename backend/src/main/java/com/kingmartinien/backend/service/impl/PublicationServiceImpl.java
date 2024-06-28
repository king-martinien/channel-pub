package com.kingmartinien.backend.service.impl;

import com.kingmartinien.backend.entity.Channel;
import com.kingmartinien.backend.entity.ExternalLink;
import com.kingmartinien.backend.entity.Publication;
import com.kingmartinien.backend.repository.ExternalLinkRepository;
import com.kingmartinien.backend.repository.PublicationRepository;
import com.kingmartinien.backend.service.ChannelService;
import com.kingmartinien.backend.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;
    private final ExternalLinkRepository externalLinkRepository;
    private final ChannelService channelService;

    @Override
    public List<Publication> getAllPublications() {
        return this.publicationRepository.findAll();
    }

    @Override
    public List<Publication> getPublicationsByChannelId(Long channelId) {
        Channel channel = channelService.getChannelById(channelId);
        return this.publicationRepository.findAllByChannel(channel);
    }

    @Override
    public Publication getPublicationById(Long id) {
        return this.publicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication not found with id: " + id));
    }

    @Override
    public Publication createPublication(Long channelId, Publication publication, MultipartFile file) {
        Channel channel = channelService.getChannelById(channelId);
        publication.setChannel(channel);
        Publication savedPublication = this.publicationRepository.save(publication);

        List<ExternalLink> externalLinks = publication.getExternalLinks();
        externalLinks.forEach(link -> link.setPublication(savedPublication));
        this.externalLinkRepository.saveAll(externalLinks);

        return this.publicationRepository.findById(savedPublication.getId())
                .orElseThrow();

    }

    @Override
    public void deletePublication(Long id) {
        Publication publication = this.getPublicationById(id);
        this.publicationRepository.delete(publication);
    }

}
