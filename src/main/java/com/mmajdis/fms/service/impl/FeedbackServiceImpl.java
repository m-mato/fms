package com.mmajdis.fms.service.impl;

import com.mmajdis.fms.domain.Feedback;
import com.mmajdis.fms.domain.User;
import com.mmajdis.fms.dto.FeedbackDTO;
import com.mmajdis.fms.repository.FeedbackRepository;
import com.mmajdis.fms.repository.UserRepository;
import com.mmajdis.fms.service.FeedbackService;
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

    private final FeedbackRepository feedbackRepository;

    private final UserRepository userRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, UserRepository userRepository) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) {

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
}
