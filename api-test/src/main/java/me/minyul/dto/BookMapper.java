package me.minyul.dto;

import me.minyul.entity.Book;

public class BookMapper {

    public static Book toEntity(BookRequestDto bookRequestDto) {
        return Book.builder()
                .content(bookRequestDto.getContent())
                .build();
    }
}
