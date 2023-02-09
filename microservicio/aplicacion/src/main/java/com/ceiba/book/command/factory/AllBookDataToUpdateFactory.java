package com.ceiba.book.command.factory;

import com.ceiba.book.command.AllBookDataCommand;
import com.ceiba.book.model.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class AllBookDataToUpdateFactory {

    public Book execute(AllBookDataCommand allBookDataCommand) {
        return new Book(allBookDataCommand.getId(), allBookDataCommand.getTitle(), allBookDataCommand.getAuthor());
    }
}
