package pl.sda.library.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private long id;
    private String author;
    private String title;
    private LocalDate returnDate;

    public Book(long id, String author, String title ) {
        this.id = id;
        this.author = author;
        this.title = title;
    }
    @JsonGetter
    public long getId() {
        return id;
    }
    @JsonIgnore
    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonGetter
    public LocalDate getReturnDate() {
        return returnDate;
    }
    @JsonIgnore
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId() &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getReturnDate(), book.getReturnDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getTitle(), getReturnDate());
    }
}

