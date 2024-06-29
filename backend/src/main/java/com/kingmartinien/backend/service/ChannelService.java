package com.kingmartinien.backend.service;

import com.kingmartinien.backend.entity.Channel;
import com.kingmartinien.backend.entity.Publication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelService {

    List<Channel> getAllChannels();

    Channel getChannelById(Long id);

    Channel createChannel(Channel channel);

    Channel updateChannel(Long id, Channel entity);

    void deleteChannel(Long id);

    List<Publication> getChannelPublications(Long channelId);

    Publication createChannelPublication(Long channelId, Publication publication, List<MultipartFile> files);

}
