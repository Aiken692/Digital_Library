package com.library.book.Author;

import com.library.book.Audit;
import com.library.book.book.Book;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "author")
public class Author extends Audit {

    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    private Long author_id;
    private String name;

    @CreatedDate
    private LocalDate created_at;

    @LastModifiedDate
    private LocalDate modified_at;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private List<Book> books;


    public Author() {
    }

    public Author(Long author_id, String name, LocalDate created_at, LocalDate modified_at, List<Book> books) {
        this.author_id = author_id;
        this.name = name;
        this.created_at = created_at;
        this.modified_at = modified_at;
        this.books = books;
    }

    public Author(String name, LocalDate created_at, LocalDate modified_at, List<Book> books) {
        this.name = name;
        this.created_at = created_at;
        this.modified_at = modified_at;
        this.books = books;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDate modified_at) {
        this.modified_at = modified_at;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                ", books=" + books +
                '}';
    }
}
