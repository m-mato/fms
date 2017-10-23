package com.mmajdis.fms.service.impl;

import com.mmajdis.fms.domain.Feedback;
import com.mmajdis.fms.domain.User;
import com.mmajdis.fms.dto.FeedbackDTO;
import com.mmajdis.fms.repository.FeedbackRepository;
import com.mmajdis.fms.repository.UserRepository;
import com.mmajdis.fms.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    private final FeedbackRepository feedbackRepository;

    private final UserRepository userRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, UserRepository userRepository) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) {

        validate(feedbackDTO);

        User author = userRepository.findFirstByUsername(feedbackDTO.getAuthorUsername());
        if (author == null) {
            author = new User();
            author.setUsername(feedbackDTO.getAuthorUsername());
            author = userRepository.save(author);
        }

        Feedback feedback = mapToBO(feedbackDTO, author);
        feedback = feedbackRepository.save(feedback);

        return mapToDTO(feedback);
    }

    @Override
    public List<FeedbackDTO> getAllFeedback() {

        List<FeedbackDTO> feedbackDTOList = new ArrayList<>();
        feedbackRepository.findAll().forEach(feedback -> feedbackDTOList.add(mapToDTO(feedback)));

        return feedbackDTOList;
    }

    @Override
    public List<FeedbackDTO> getFeedbackByUsername(String username) {

        if (username == null || username.isEmpty()) {
            sendValidationError("Username needs to be specified");
        }

        List<FeedbackDTO> feedbackDTOList = new ArrayList<>();
        feedbackRepository.findAllByAuthorUsername(username).forEach(feedback -> feedbackDTOList.add(mapToDTO(feedback)));

        return feedbackDTOList;
    }

    private Feedback mapToBO(FeedbackDTO feedbackDTO, User author) {
        Feedback feedback = new Feedback();
        feedback.setMessage(feedbackDTO.getMessage());
        feedback.setAuthor(author);

        return feedback;
    }

    private FeedbackDTO mapToDTO(Feedback feedback) {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setId(feedback.getId());
        feedbackDTO.setMessage(feedback.getMessage());
        feedbackDTO.setCreated(ZonedDateTime.ofInstant(feedback.getCreated().toInstant(), ZoneId.systemDefault()));
        feedbackDTO.setAuthorUsername((feedback.getAuthor() != null) ? feedback.getAuthor().getUsername() : null);

        return feedbackDTO;
    }

    private void validate(FeedbackDTO feedbackDTO) {
        if (feedbackDTO == null) {
            sendValidationError("Feedback DTO must not be null");
        } else if (feedbackDTO.getAuthorUsername() == null || feedbackDTO.getAuthorUsername().isEmpty()) {
            sendValidationError("Author's username needs to be specified");
        } else if (feedbackDTO.getMessage() == null || feedbackDTO.getMessage().isEmpty()) {
            sendValidationError("Message needs to be specified");
        }
    }

    private void sendValidationError(String message) {
        LOGGER.debug(message);
        throw new IllegalArgumentException(message);
    }
}
