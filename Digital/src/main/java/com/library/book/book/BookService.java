package com.library.book.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    Get all books
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

//    Get a single book
    public Book getBookById(long id) {
        return bookRepository.findById(id).get();
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        boolean exits = bookRepository.existsById(id);
        if(!exits){
            throw new IllegalStateException(
                    "Book with Id" + id + "does not eist"
            );
        }
        bookRepository.deleteById(id);
    }

//    Update the book
    @Transactional
    public void updateBook(long id, String book_name, String book_detail) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Book with id" + id + "does not exist"
                ));
    }
}
