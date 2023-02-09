package com.ceiba.book.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllBookDataCommand {
    private Long id;
    private String title;
    private String author;
}
