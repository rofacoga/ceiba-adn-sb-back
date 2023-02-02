package com.ceiba.book.controller;

import com.ceiba.ComandoRespuesta;
import com.ceiba.book.command.AllBookDataCommand;
import com.ceiba.book.command.BookCommand;
import com.ceiba.book.command.handler.BookCreateHandler;
import com.ceiba.book.command.handler.UpdateAllBookDataHandler;
import com.ceiba.book.model.entity.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Tag(name = "Book command controller")
public class CommandControllerBook {

    private final BookCreateHandler createHandler;
    private final UpdateAllBookDataHandler updateAllBookDataHandler;

    public CommandControllerBook(BookCreateHandler bookCreateHandler, UpdateAllBookDataHandler updateAllBookDataHandler) {
        this.createHandler = bookCreateHandler;
        this.updateAllBookDataHandler = updateAllBookDataHandler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create", description = "Method used to create the books")
    public ComandoRespuesta<Long> create(@RequestBody BookCommand bookCommand) {
        return this.createHandler.ejecutar(bookCommand);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update All Book Data", description = "Method used to update all data for a book")
    public ComandoRespuesta<Book> updateAllBookData(@RequestBody AllBookDataCommand allBookDataCommand) {
        return this.updateAllBookDataHandler.ejecutar(allBookDataCommand);
    }
}
