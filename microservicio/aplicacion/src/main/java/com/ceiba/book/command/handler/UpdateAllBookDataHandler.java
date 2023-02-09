package com.ceiba.book.command.handler;

import com.ceiba.ComandoRespuesta;
import com.ceiba.book.command.AllBookDataCommand;
import com.ceiba.book.command.factory.AllBookDataToUpdateFactory;
import com.ceiba.book.model.entity.Book;
import com.ceiba.book.service.UpdateAllBookDataService;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class UpdateAllBookDataHandler implements ManejadorComandoRespuesta<AllBookDataCommand, ComandoRespuesta<Book>> {

    private final AllBookDataToUpdateFactory allBookDataToUpdateFactory;
    private final UpdateAllBookDataService updateAllBookDataService;

    public UpdateAllBookDataHandler(AllBookDataToUpdateFactory allBookDataToUpdateFactory,
                                    UpdateAllBookDataService updateAllBookDataService) {
        this.allBookDataToUpdateFactory = allBookDataToUpdateFactory;
        this.updateAllBookDataService = updateAllBookDataService;
    }

    @Override
    public ComandoRespuesta<Book> ejecutar(AllBookDataCommand bookCreateRequest) {
        return new ComandoRespuesta<>(
                this.updateAllBookDataService.execute(
                        this.allBookDataToUpdateFactory.execute(bookCreateRequest)));
    }
}
