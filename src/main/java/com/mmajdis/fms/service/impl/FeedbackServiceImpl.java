package com.mmajdis.fms.service.impl;

import com.mmajdis.fms.dto.FeedbackDTO;
import com.mmajdis.fms.repository.FeedbackRepository;
import com.mmajdis.fms.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public List<FeedbackDTO> getAllFeedBack() {

        List<FeedbackDTO> feedbackDTOList = new ArrayList<>();

        feedbackRepository.findAll().forEach(feedback -> {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setMessage(feedback.getMessage());
            feedbackDTOList.add(feedbackDTO);
        });

        return feedbackDTOList;
    }
}
