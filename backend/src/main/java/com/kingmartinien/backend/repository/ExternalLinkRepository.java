package com.kingmartinien.backend.repository;

import com.kingmartinien.backend.entity.ExternalLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalLinkRepository extends JpaRepository<ExternalLink, Long> {
}
