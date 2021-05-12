package com.library.book.Author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //    Get all Authors
    @GetMapping("/author")
    public List<Author> getAuthors(){

        return authorService.getAuthors();

    }

//    Get a particular author
    @GetMapping("/author/{id}")
    public Author getSingleAuthor(@PathVariable long id){
        return authorService.getAuthorById(id);
    }

// Putting a new author
    @PostMapping("/author")
    public String registerNewAuthor(@RequestBody Author author){
        authorService.addNewAuthor(author);
        return "New Author Registered";
    }

    //Deleting an author by Id
    @DeleteMapping("/author/{id}")
    public String deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthor(id);
        return "Author deleted successfully";
    }

//    Update Author
    @PutMapping("/author/{id}")
    public void updateAuthor (@PathVariable long id, @RequestParam String name){
        authorService.updateAuthor(id, name);
    }
}


