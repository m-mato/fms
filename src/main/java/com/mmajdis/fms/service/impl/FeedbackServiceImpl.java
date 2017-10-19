package com.mmajdis.fms.service.impl;

import com.mmajdis.fms.dto.FeedbackDTO;
import com.mmajdis.fms.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//TODO DB @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class FeedbackServiceImpl implements FeedbackService {

    @Override
    public List<FeedbackDTO> getAllFeedBack() {

        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setMessage("OK !");

        List<FeedbackDTO> feedbackDTOs = new ArrayList<>();
        feedbackDTOs.add(feedbackDTO);

        return feedbackDTOs;
    }
}
