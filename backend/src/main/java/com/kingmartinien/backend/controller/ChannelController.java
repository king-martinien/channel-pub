package com.kingmartinien.backend.controller;

import com.kingmartinien.backend.dto.ChannelDto;
import com.kingmartinien.backend.mapper.ChannelMapper;
import com.kingmartinien.backend.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;
    private final ChannelMapper channelMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ChannelDto> getAllChannels() {
        return this.channelMapper.toDto(this.channelService.getAllChannels());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChannelDto getChannelById(@PathVariable Long id) {
        return this.channelMapper.toDto(this.channelService.getChannelById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChannelDto createChannel(@RequestBody ChannelDto channelDto) {
        return this.channelMapper.toDto(this.channelService.createChannel(this.channelMapper.toEntity(channelDto)));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChannelDto updateChannel(@PathVariable Long id, @RequestBody ChannelDto channelDto) {
        return this.channelMapper.toDto(this.channelService.updateChannel(id, this.channelMapper.toEntity(channelDto)));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteChannel(@PathVariable Long id) {
        this.channelService.deleteChannel(id);
    }

}
