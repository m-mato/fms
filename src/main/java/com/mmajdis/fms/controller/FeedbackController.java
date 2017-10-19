package com.mmajdis.fms.controller;

import com.mmajdis.fms.dto.FeedbackDTO;
import com.mmajdis.fms.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<FeedbackDTO> getAll() {

        return feedbackService.getAllFeedBack();
    }
}
