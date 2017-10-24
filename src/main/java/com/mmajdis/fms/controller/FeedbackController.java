package com.mmajdis.fms.controller;

import com.mmajdis.fms.dto.FeedbackDTO;
import com.mmajdis.fms.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * REST controller for feedback-related requests.
 *
 * @author Matej Majdis [<a href="mailto:mato.majdis@gmail.com">mato.majdis@gmail.com</a>]
 */
@RestController
@RequestMapping("feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    /**
     * Creates feedback with message for given author.
     *
     * @param feedbackDTO DTO object which username and message needs to be specified in.
     * @return {@link FeedbackDTO} containing complete information about created feedback.
     */
    @RequestMapping(method = RequestMethod.POST)
    public FeedbackDTO create(@Valid @RequestBody FeedbackDTO feedbackDTO) {

        return feedbackService.createFeedback(feedbackDTO);
    }

    /**
     * Returns all feedback objects.
     *
     * @return {@link List<FeedbackDTO>} all feedback objects represented by List of {@link FeedbackDTO}.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<FeedbackDTO> getAll() {

        return feedbackService.getAllFeedback();
    }

    /**
     * Returns list of feedback objects for given author.
     *
     * @param username username of author to filter feedback for.
     * @return {@link List<FeedbackDTO>} filtered author's feedback objects.
     */
    @RequestMapping(value = "filter", method = RequestMethod.GET)
    public List<FeedbackDTO> getByUsername(@RequestParam(name = "username") String username, HttpServletResponse response) throws IOException {

        if (username.isEmpty()) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "Username can not be empty");
            return null;
        }

        return feedbackService.getFeedbackByUsername(username);
    }
}
