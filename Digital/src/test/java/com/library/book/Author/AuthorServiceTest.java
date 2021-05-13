package com.library.book.Author;

import com.sun.javaws.JnlpxArgs;
import javafx.beans.binding.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;
    private AuthorService underTest;

    @BeforeEach
    void setUp() {

        underTest = new AuthorService(authorRepository);
    }


    @Test
    void canGetAuthors() {

//        When
        underTest.getAuthors();
//        Then
        verify(authorRepository).findAll();
    }

    @Disabled
    void  canDeleteAuthor(long id){
        boolean exists = authorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Author with Id " + id + " does not exist"
            );
        }

//        When
        underTest.deleteAuthor(id);
//        Then
        verify(authorRepository).deleteById(id);
    }
}