package com.kingmartinien.backend.controller;

import com.kingmartinien.backend.dto.ChannelDto;
import com.kingmartinien.backend.dto.PublicationDto;
import com.kingmartinien.backend.mapper.ChannelMapper;
import com.kingmartinien.backend.mapper.PublicationMapper;
import com.kingmartinien.backend.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;
    private final ChannelMapper channelMapper;
    private final PublicationMapper publicationMapper;

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

    @GetMapping("{id}/publications")
    @ResponseStatus(HttpStatus.OK)
    public List<PublicationDto> getPublicationsByChannelId(@PathVariable Long id) {
        return this.publicationMapper.toDto(this.channelService.getChannelPublications(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChannelDto createChannel(@RequestBody ChannelDto channelDto) {
        return this.channelMapper.toDto(this.channelService.createChannel(this.channelMapper.toEntity(channelDto)));
    }

    @PostMapping("{id}/publications")
    @ResponseStatus(HttpStatus.CREATED)
    public PublicationDto createChannelPublication(
            @PathVariable Long id,
            @RequestPart("publication") PublicationDto publicationDto,
            @RequestPart(value = "files", required = false) List<MultipartFile> files) {
        return this.publicationMapper.toDto(
                this.channelService.createChannelPublication(
                        id, this.publicationMapper.toEntity(publicationDto), files));
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
