package com.mmajdis.fms.controller;

import com.mmajdis.fms.dto.FeedbackDTO;
import com.mmajdis.fms.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public FeedbackDTO create(@RequestBody FeedbackDTO feedbackDTO) {

        return feedbackService.createFeedback(feedbackDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<FeedbackDTO> getAll() {

        return feedbackService.getAllFeedback();
    }

    @RequestMapping(value = "filter", method = RequestMethod.GET)
    public List<FeedbackDTO> getByUsername(@RequestParam(name = "username") String username) {

        return feedbackService.getFeedbackByUsername(username);
    }
}
