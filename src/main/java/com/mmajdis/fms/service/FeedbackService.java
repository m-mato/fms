package com.mmajdis.fms.service;

import com.mmajdis.fms.dto.FeedbackDTO;

import java.util.List;

public interface FeedbackService {

    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO);

    List<FeedbackDTO> getAllFeedback();

    List<FeedbackDTO> getFeedbackByUsername(String username);
}
