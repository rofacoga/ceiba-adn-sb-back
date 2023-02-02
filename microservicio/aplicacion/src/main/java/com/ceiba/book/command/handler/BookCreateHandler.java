package com.ceiba.book.command.handler;

import com.ceiba.ComandoRespuesta;
import com.ceiba.book.command.BookCommand;
import com.ceiba.book.command.factory.BookCreateRequestFactory;
import com.ceiba.book.service.CreateBookService;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class BookCreateHandler implements ManejadorComandoRespuesta<BookCommand, ComandoRespuesta<Long>> {

    private final BookCreateRequestFactory createRequestFactory;
    private final CreateBookService createBookService;

    public BookCreateHandler(BookCreateRequestFactory createRequestFactory, CreateBookService createBookService) {
        this.createRequestFactory = createRequestFactory;
        this.createBookService = createBookService;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(BookCommand bookCreateRequest) {
        return new ComandoRespuesta<>(
                createBookService.execute(
                        createRequestFactory.execute(bookCreateRequest)));
    }

}
