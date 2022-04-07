package de.neuefische.booklibraryspring.service;


import de.neuefische.booklibraryspring.api.IsbnApi;
import de.neuefische.booklibraryspring.model.Book;
import de.neuefische.booklibraryspring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private final BookRepository bookRepo;
    private final IsbnApi isbnApi;


    @Autowired
    public BookService(BookRepository bookRepo, IsbnApi isbnApi) {
        this.bookRepo = bookRepo;
        this.isbnApi = isbnApi;
    }

    public List<Book> getAllBooks(){
        return bookRepo.list();
    }

    public Book getByIsbn(String isbn) {
        return bookRepo.getByIsbn(isbn)
                .orElseThrow(() -> new NoSuchElementException("Book not found with this ibn: " + isbn));
    }

    public Book addBook(Book book) {
        bookRepo.add(book);
        return book;
    }

    public void deleteBookByIsbn(String isbn) {
        bookRepo.delete(isbn);
    }


    public List<Book> getBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookRepo.list()){
            if (book.getTitle().equals(title)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public Book addBookByIsbn(String isbn) {
        Book bookToAdd = isbnApi.getBookByIsbn(isbn)
                .orElseThrow(() -> new NoSuchElementException("Book not found with this ibn: " + isbn));
        bookRepo.add(bookToAdd);
        return bookToAdd;
    }
}
