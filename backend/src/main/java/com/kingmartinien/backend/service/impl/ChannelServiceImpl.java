package com.kingmartinien.backend.service.impl;

import com.kingmartinien.backend.entity.Attachment;
import com.kingmartinien.backend.entity.Channel;
import com.kingmartinien.backend.entity.ExternalLink;
import com.kingmartinien.backend.entity.Publication;
import com.kingmartinien.backend.firebase.FirebaseStorageService;
import com.kingmartinien.backend.repository.AttachmentRepository;
import com.kingmartinien.backend.repository.ChannelRepository;
import com.kingmartinien.backend.repository.ExternalLinkRepository;
import com.kingmartinien.backend.repository.PublicationRepository;
import com.kingmartinien.backend.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final PublicationRepository publicationRepository;
    private final ExternalLinkRepository externalLinkRepository;
    private final AttachmentRepository attachmentRepository;
    private final FirebaseStorageService firebaseStorageService;

    @Override
    public List<Channel> getAllChannels() {
        return this.channelRepository.findAll();
    }

    @Override
    public Channel getChannelById(Long id) {
        return this.channelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Channel not found with id: " + id));
    }

    @Override
    public Channel createChannel(Channel channel) {
        Optional<Channel> optionalChannel = this.channelRepository.findByName(channel.getName());
        if (optionalChannel.isPresent()) {
            throw new RuntimeException("Channel with name " + channel.getName() + " already exists");
        }
        return this.channelRepository.save(channel);
    }

    @Override
    public Channel updateChannel(Long id, Channel channel) {
        Channel channelToUpdate = this.getChannelById(id);
        channelToUpdate.setName(channel.getName());
        return this.channelRepository.save(channelToUpdate);
    }

    @Override
    public void deleteChannel(Long id) {
        Channel channelToDelete = this.getChannelById(id);
        this.channelRepository.delete(channelToDelete);
    }

    @Override
    public List<Publication> getChannelPublications(Long channelId) {
        Channel channel = this.getChannelById(channelId);
        return channel.getPublications();
    }

    @Override
    public Publication createChannelPublication(Long channelId, Publication publication, List<MultipartFile> files) {
        Channel channel = this.getChannelById(channelId);
        publication.setChannel(channel);
        Publication savedPublication = this.publicationRepository.save(publication);

        List<ExternalLink> externalLinks = publication.getExternalLinks();
        if (externalLinks != null) {
            externalLinks.forEach(link -> link.setPublication(savedPublication));
            this.externalLinkRepository.saveAll(externalLinks);
        }

        if (files != null && !files.isEmpty()) {
            files.forEach(file -> {
                Attachment attachment;
                try {
                    attachment = Attachment.builder()
                            .fileName(file.getOriginalFilename())
                            .fileType(file.getContentType())
                            .blobId(this.firebaseStorageService.uploadFile(file))
                            .build();
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
                attachment.setPublication(savedPublication);
                this.attachmentRepository.save(attachment);
            });
        }

        return this.publicationRepository.findById(savedPublication.getId())
                .orElseThrow();
    }

}
