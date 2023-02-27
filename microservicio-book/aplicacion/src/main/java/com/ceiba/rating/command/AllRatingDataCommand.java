package com.ceiba.rating.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllRatingDataCommand {
    private Long id;
    private Long bookId;
    private int stars;
}
