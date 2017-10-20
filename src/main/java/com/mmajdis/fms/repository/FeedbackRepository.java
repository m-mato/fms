package com.mmajdis.fms.repository;

import com.mmajdis.fms.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
