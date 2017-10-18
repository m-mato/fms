package com.mmajdis.fms.controller;

import com.mmajdis.fms.dto.FeedbackDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {


    @RequestMapping(method = RequestMethod.GET)
    public Collection<FeedbackDTO> getAll() {

        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setMessage("OK !");

        List<FeedbackDTO> feedbackDTOs = new ArrayList<>();
        feedbackDTOs.add(feedbackDTO);

        return feedbackDTOs;
    }
}
