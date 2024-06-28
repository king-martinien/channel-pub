package com.kingmartinien.backend.repository;

import com.kingmartinien.backend.entity.Channel;
import com.kingmartinien.backend.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

    List<Publication> findAllByChannel(Channel channel);

}
