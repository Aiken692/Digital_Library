package com.library.book.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

//    Find all authors
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

//    Add new Author
    public void addNewAuthor(Author author) {
        authorRepository.save(author);
    }

//    Find Author by Id
    public Author getAuthorById(long id) {
       return authorRepository.findById(id).get();
    }

//    Delete Author
    public void deleteAuthor(long id) {
       boolean exists = authorRepository.existsById(id);
       if (!exists) {
           throw new IllegalStateException(
                   "Author with Id " + id + " does not exist"
           );
       }
       authorRepository.deleteById(id);

    }


//    Update the Author
    @Transactional
    public void updateAuthor(long id, String name) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                    "author with id " + id + " does not exist"
                ));
        if(name !=null  && name.length() > 0 && !Objects.equals(author.getName(), name)){
            author.setName(name);
        }
    }
}
