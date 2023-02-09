package com.ceiba.book.controller;

import com.ceiba.ApplicationMock;
import com.ceiba.book.command.AllBookDataCommand;
import com.ceiba.book.command.BookCommand;
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
@WebMvcTest(CommandControllerBook.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CommandControllerBookTest {

    public static final String URL_TEMPLATE = "/books";
    public static final String JSON_RESULT_ID = "$.valor.id";
    public static final String JSON_RESULT_TITLE = "$.valor.title";
    public static final String JSON_RESULT_AUTHOR = "$.valor.author";
    public static final String JSON_RESULT_VALOR = "$.valor";

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createBook() throws Exception {
        final String title = "Clean Architecture";
        final String author = "Robert C. Martin";
        BookCommand bookCommand = new BookCommand(title, author);

        mocMvc.perform(post(URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookCommand)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath(JSON_RESULT_VALOR, is(4)));

    }

    @Test
    void updateBookWithId2() throws Exception {
        final Long id = 2L;
        final String title = "Clean Architecture";
        final String author = "Robert C. Martin";
        AllBookDataCommand bookCommand = new AllBookDataCommand(id, title, author);

        mocMvc.perform(put(URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookCommand)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath(JSON_RESULT_ID, is(id.intValue())))
                .andExpect(jsonPath(JSON_RESULT_TITLE, is(title)))
                .andExpect(jsonPath(JSON_RESULT_AUTHOR, is(author)));

    }
}
