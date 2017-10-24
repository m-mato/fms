package com.mmajdis.fms.service;

import com.mmajdis.fms.dto.FeedbackDTO;

import java.util.List;

/**
 * Service interface for operation with {@link FeedbackDTO}.
 *
 * @author Matej Majdis [<a href="mailto:mato.majdis@gmail.com">mato.majdis@gmail.com</a>]
 * @see FeedbackDTO
 */
public interface FeedbackService {

    /**
     * Creates feedback with message for given author.
     *
     * @param feedbackDTO DTO object which username and message needs to be specified in.
     * @return {@link FeedbackDTO} containing complete information about created feedback.
     */
    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO);

    /**
     * Gets all feedback objects
     *
     * @return {@link List<FeedbackDTO>} found feedback objects
     */
    List<FeedbackDTO> getAllFeedback();

    /**
     * Gets feedback objects by username.
     *
     * @param username author's username
     * @return {@link List<FeedbackDTO>} filtered feedback objects
     */
    List<FeedbackDTO> getFeedbackByUsername(String username);
}
