package com.kingmartinien.backend.repository;

import com.kingmartinien.backend.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
