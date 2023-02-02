package com.ceiba.book.controller;

import com.ceiba.ComandoRespuesta;
import com.ceiba.book.command.BookCommand;
import com.ceiba.book.command.handler.BookCreateHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Tag(name = "Book command controller")
public class CommandControllerBook {

    private final BookCreateHandler createHandler;

    public CommandControllerBook(BookCreateHandler bookCreateHandler) {
        this.createHandler = bookCreateHandler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create", description = "Method used to create the books")
    public ComandoRespuesta<Long> create(@RequestBody BookCommand bookCommand) {
        return this.createHandler.ejecutar(bookCommand);
    }
}
