package me.minyul.service;

import lombok.RequiredArgsConstructor;
import me.minyul.dto.BookMapper;
import me.minyul.dto.BookRequestDto;
import me.minyul.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public void save(BookRequestDto request) {
        bookRepository.save(BookMapper.toEntity(request));
    }
}
