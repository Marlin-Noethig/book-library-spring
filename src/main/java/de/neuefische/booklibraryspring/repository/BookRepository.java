package de.neuefische.booklibraryspring.repository;

import de.neuefische.booklibraryspring.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookRepository {

    private Map<String, Book> books = new HashMap<>();

    public List<Book> list() {
        return new ArrayList<>(books.values());
    }

    public Optional<Book> getByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public void add(Book book) {
        books.put(book.getId(), book);
    }

    public void delete(String isbn) {
        books.remove(isbn);
    }


    public void deleteAll() {
        this.books = new HashMap<>();
    }
}
