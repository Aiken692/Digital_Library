package com.library.book.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    private BookService underTest;


    @BeforeEach
    void setUp() {
        underTest = new BookService(bookRepository);
    }

    @Test
    void getBooks() {
//        When
        underTest.getBooks();
//        Then
        verify(bookRepository).findAll();
    }
}