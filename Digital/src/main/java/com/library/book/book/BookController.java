package com.library.book.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //    Get books
    @GetMapping("/book")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

//    Get a single book
    @GetMapping("/book/{id}")
    public Book getSingleBook(@PathVariable long id){
        return bookService.getBookById(id);
    }

//    Posting a new book
    @PostMapping("/book")
    public String addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
        return "New Book Added";
    }

//    Deleting an book by Id
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
    }

//    Update Book
    @PutMapping("/book/{id}")
    public void updateBook (@PathVariable long id, @RequestParam String book_name, @RequestParam String book_detail){
        bookService.updateBook(id, book_name, book_detail);
    }
}
