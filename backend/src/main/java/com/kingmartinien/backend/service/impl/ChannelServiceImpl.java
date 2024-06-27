package com.kingmartinien.backend.service.impl;

import com.kingmartinien.backend.entity.Channel;
import com.kingmartinien.backend.repository.ChannelRepository;
import com.kingmartinien.backend.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;

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

}
