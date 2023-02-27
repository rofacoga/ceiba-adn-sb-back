package com.ceiba.book.controller;

import com.ceiba.book.model.dto.BookDTO;
import com.ceiba.book.query.BookByIdQueryHandler;
import com.ceiba.book.query.GetAllBooksQueryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Book query controller")
public class QueryControllerBook {

    private final GetAllBooksQueryHandler getAllBooksQueryHandler;
    private final BookByIdQueryHandler bookByIdQueryHandler;

    public QueryControllerBook(GetAllBooksQueryHandler getAllBooksQueryHandler, BookByIdQueryHandler bookByIdQueryHandler) {
        this.getAllBooksQueryHandler = getAllBooksQueryHandler;
        this.bookByIdQueryHandler = bookByIdQueryHandler;
    }

    @GetMapping
    @Operation(summary = "Get all books", description = "Method used to get all books")
    public List<BookDTO> getAll() {
        return this.getAllBooksQueryHandler.execute();
    }

    @GetMapping("/{id-book}")
    @Operation(summary = "Get by Id", description = "Method used to get a book")
    public BookDTO getById(@PathVariable("id-book") Long id) {
        return this.bookByIdQueryHandler.execute(id);
    }
}
