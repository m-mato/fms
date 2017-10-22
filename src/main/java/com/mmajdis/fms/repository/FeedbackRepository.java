package com.mmajdis.fms.repository;

import com.mmajdis.fms.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("SELECT f FROM Feedback f WHERE f.author.username = :username")
    List<Feedback> findAllByAuthorUsername(@Param("username") String username);
}
