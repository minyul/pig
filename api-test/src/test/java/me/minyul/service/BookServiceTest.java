package me.minyul.service;

import me.minyul.dto.BookRequestDto;
import me.minyul.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void shouldCallBookRepositorySaveMethod() {
        // given
        BookRequestDto dto = new BookRequestDto("content");

        // when
        bookService.save(dto);

        // then
        verify(bookRepository).save(any());
    }
}