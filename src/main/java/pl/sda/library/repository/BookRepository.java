package pl.sda.library.repository;

import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Repository;
import pl.sda.library.model.Book;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BookRepository {
    private Set<Book> bookSet = createListOfBooks();

    private Set<Book> createListOfBooks() {
        Book book1 = new Book(1,"J.K.Rowling","Harry Potter");
        Book book2 = new Book(2,"Andrzej Ziemianski","Achaja Tom1");
        Book book3 = new Book(3,"Andrzej Ziemianski","Achaja Tom2");
        Book book4 = new Book(4,"Andrzej Ziemianski","Achaja Tom3");
        Book book5 = new Book(5,"Andrzej Sapkowski","Wiedzmin Tom1");
        Book book6 = new Book(6,"Andrzej Sapkowski","Wiedzmin Tom2");
        Book book7 = new Book(7,"Andrzej Sapkowski","Wiedzmin Tom3");
        Book book8 = new Book(8,"Andrzej Sapkowski","Wiedzmin Tom4");
        Book book9 = new Book(9,"Andrzej Sapkowski","Wiedzmin Tom5");
        Book book10 = new Book(10,"Ernest Hemingway","Stary czlowiek i morze");

        return new HashSet<>(Arrays.asList(book1,book2,book3,book4,book5,book6,book7,book8,book9,book10));
    }

    public Set<Book> getBookSet(String title) {
        if (title == null) {
            return bookSet;
        } else {
            return bookSet.stream()
                    .filter(book -> book.getTitle().equals(title))
                    .collect(Collectors.toSet());
        }
    }
    public Optional<Book> rentBook (Long id, LocalDate returnDate){
        Optional<Book> bookOptional = bookSet.stream()
                .filter(book -> book.getId()==(id))
                .filter(book -> book.getReturnDate()==null)
                .findAny();
        bookOptional.ifPresent(book -> book.setReturnDate(returnDate));
        return bookOptional;
    }
    public Book addBook(Book book){
        long maxBookSetId = bookSet.stream()
                .mapToLong(actualBook -> actualBook.getId())
                .max().getAsLong()+ 1;
        book.setId(maxBookSetId);
        bookSet.add(book);
        return book;
    }
    public boolean removeBook(Long id){
        Optional<Book> bookById = bookSet.stream().filter(actualBook -> actualBook.getId()==(id)).findAny();
        boolean present = bookById.isPresent();
        if(present){
            Book bookToRemove = bookById.get();
            bookSet.remove(bookToRemove);
        }
        return present;
    }
}
