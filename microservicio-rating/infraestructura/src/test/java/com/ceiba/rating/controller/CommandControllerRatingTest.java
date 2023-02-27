package com.ceiba.rating.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.rating.command.AllRatingDataCommand;
import com.ceiba.rating.command.RatingCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CommandControllerRating.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CommandControllerRatingTest {

    public static final String URL_TEMPLATE = "/ratings";
    public static final String JSON_RESULT_ID = "$.valor.id";
    public static final String JSON_RESULT_BOOK_ID = "$.valor.bookId";
    public static final String JSON_RESULT_STARS = "$.valor.stars";
    public static final String JSON_RESULT_VALOR = "$.valor";

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createRatingSuccessful() throws Exception {
        final Long bookId = 1L;
        final int stars = 5;
        RatingCommand ratingCommand = new RatingCommand(bookId, stars);

        mocMvc.perform(post(URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ratingCommand)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath(JSON_RESULT_VALOR, is(5)));
    }

    @Test
    void updateRatingWithId3AndBookId2Successful() throws Exception {
        final Long id = 3L;
        final Long bookId = 2L;
        final int stars = 5;
        AllRatingDataCommand ratingCommand = new AllRatingDataCommand(id, bookId, stars);

        mocMvc.perform(put(URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ratingCommand)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath(JSON_RESULT_ID, is(3)))
                .andExpect(jsonPath(JSON_RESULT_BOOK_ID, is(bookId.intValue())))
                .andExpect(jsonPath(JSON_RESULT_STARS, is(stars)));
    }
}
