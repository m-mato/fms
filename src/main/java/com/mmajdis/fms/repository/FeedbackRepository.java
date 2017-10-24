package com.mmajdis.fms.repository;

import com.mmajdis.fms.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JPA repository for {@link Feedback} entity.
 *
 * @author Matej Majdis [<a href="mailto:mato.majdis@gmail.com">mato.majdis@gmail.com</a>]
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    /**
     * Filters list of feedback objects by author's username.
     *
     * @param username author's username
     * @return found {@link List<Feedback>}
     */
    @Query("SELECT f FROM Feedback f WHERE f.author.username = :username")
    List<Feedback> findAllByAuthorUsername(@Param("username") String username);
}
