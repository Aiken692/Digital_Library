package com.library.book.book;

import com.library.book.Audit;
import com.library.book.Author.Author;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="book")
public class Book extends Audit {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private long book_id;
    private String book_name;
    private String book_detail;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;
    private Integer author_id;

    @CreatedDate
    private LocalDate created_at;

    @LastModifiedDate
    private LocalDate modified_at;

    public Book() {
    }

    public Book(long book_id, String book_name, String book_detail, Integer author_id, LocalDate created_at, LocalDate modified_at) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_detail = book_detail;
        this.author_id = author_id;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Book(String book_name, String book_detail, Integer author_id, LocalDate created_at, LocalDate modified_at) {
        this.book_name = book_name;
        this.book_detail = book_detail;
        this.author_id = author_id;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_detail() {
        return book_detail;
    }

    public void setBook_detail(String book_detail) {
        this.book_detail = book_detail;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
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

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_detail='" + book_detail + '\'' +
                ", author_id=" + author_id +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }
}
