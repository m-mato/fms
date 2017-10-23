package com.mmajdis.fms.service.impl;

import com.mmajdis.fms.domain.Feedback;
import com.mmajdis.fms.dto.FeedbackDTO;
import com.mmajdis.fms.repository.FeedbackRepository;
import com.mmajdis.fms.service.FeedbackService;
import com.mmajdis.fms.test.AbstractFMSTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FeedbackServiceImplTest extends AbstractFMSTest {

    private static final String USERNAME_EXISTING = "mato137";
    private static final String USERNAME_NEW = "testUser-CreateFeedback";
    private static final String MESSAGE = "test";

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackService feedbackService;

    @Test
    public void testGetAllFeedback() {
        List<FeedbackDTO> feedbackDTOList = feedbackService.getAllFeedback();

        assertNotNull(feedbackDTOList);
        assertEquals(feedbackDTOList.size(), 6);

        assertFeedbackListNotNull(feedbackDTOList);
    }

    @Test
    public void testGetFeedbackByUsername() {
        List<FeedbackDTO> feedbackDTOList = feedbackService.getFeedbackByUsername(USERNAME_EXISTING);

        assertNotNull(feedbackDTOList);
        assertEquals(2, feedbackDTOList.size());
        assertFeedbackListNotNull(feedbackDTOList);

        for(FeedbackDTO feedbackDTO : feedbackDTOList) {
            assertEquals(USERNAME_EXISTING, feedbackDTO.getAuthorUsername());
        }
    }

    @Test
    public void testGetFeedbackByUsernameNotExists() {
        List<FeedbackDTO> feedbackDTOList = feedbackService.getFeedbackByUsername(USERNAME_EXISTING + "f");

        assertNotNull(feedbackDTOList);
        assertEquals(0, feedbackDTOList.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFeedbackByUsernameNull() {
        feedbackService.getFeedbackByUsername(null);
    }

    @Test
    public void testCreateFeedbackNewUser() {

        FeedbackDTO feedbackDTOExpected = new FeedbackDTO();
        feedbackDTOExpected.setAuthorUsername(USERNAME_NEW);
        feedbackDTOExpected.setMessage(MESSAGE);
        FeedbackDTO feedbackDTOActual = feedbackService.createFeedback(feedbackDTOExpected);

        assertNotNull(feedbackDTOActual);

        assertNotNull(feedbackDTOActual.getId());
        assertNotNull(feedbackDTOActual.getCreated());

        assertNotNull(feedbackDTOActual.getAuthorUsername());
        assertEquals(feedbackDTOExpected.getAuthorUsername(), feedbackDTOActual.getAuthorUsername());

        assertNotNull(feedbackDTOActual.getMessage());
        assertEquals(feedbackDTOExpected.getMessage(), feedbackDTOActual.getMessage());

        assertNotNull(feedbackRepository.findAllByAuthorUsername(USERNAME_NEW));

        cleanUp(feedbackDTOActual.getId());
    }

    @Test
    public void testCreateFeedbackExistingUser() {

        FeedbackDTO feedbackDTOExpected = new FeedbackDTO();
        feedbackDTOExpected.setAuthorUsername(USERNAME_EXISTING);
        feedbackDTOExpected.setMessage(MESSAGE);
        FeedbackDTO feedbackDTOActual = feedbackService.createFeedback(feedbackDTOExpected);

        assertNotNull(feedbackDTOActual);

        assertNotNull(feedbackDTOActual.getId());
        assertNotNull(feedbackDTOActual.getCreated());

        assertNotNull(feedbackDTOActual.getAuthorUsername());
        assertEquals(feedbackDTOExpected.getAuthorUsername(), feedbackDTOActual.getAuthorUsername());

        assertNotNull(feedbackDTOActual.getMessage());
        assertEquals(feedbackDTOExpected.getMessage(), feedbackDTOActual.getMessage());

        List<Feedback> feedbackList = feedbackRepository.findAllByAuthorUsername(USERNAME_EXISTING);
        assertEquals(3, feedbackList.size());

        cleanUp(feedbackDTOActual.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFeedbackDTONull() {
        feedbackService.createFeedback(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFeedbackUsernameNull() {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setMessage(MESSAGE);

        feedbackService.createFeedback(feedbackDTO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFeedbackMessageNull() {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setAuthorUsername(USERNAME_NEW);

        feedbackService.createFeedback(feedbackDTO);
    }

    private void assertFeedbackListNotNull(List<FeedbackDTO> feedbackDTOList) {
        for(FeedbackDTO feedbackDTO : feedbackDTOList) {
            assertNotNull(feedbackDTO);
            assertNotNull(feedbackDTO.getId());
            assertNotNull(feedbackDTO.getMessage());
            assertNotNull(feedbackDTO.getAuthorUsername());
            assertNotNull(feedbackDTO.getCreated());
        }
    }

    private void cleanUp(Long... feedbackId) {
        for (Long id : feedbackId) {
            feedbackRepository.delete(id);
        }
    }
}
