package de.neuefische.booklibraryspring.controller;


import de.neuefische.booklibraryspring.model.Book;
import de.neuefische.booklibraryspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")

public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<Book> getAllBooks (){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{isbn}")
    public Book getBookByIsbn (@PathVariable String isbn){
        return bookService.getByIsbn(isbn);
    }


    @GetMapping(path = "/titles")
    public List<Book> getBooksByTitle(@RequestParam String title){
        return bookService.getBooksByTitle(title);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        bookService.addBook(book);
        return book;
    }

    @PutMapping(path ="/api/{isbn}")
    public Book addBookByIsbn(@PathVariable String isbn){
        return bookService.addBookByIsbn(isbn);
    }


    @DeleteMapping(path = "{isbn}")
    public String deleteBookByIsbn (@PathVariable String isbn){
        Book bookToDelete = bookService.getByIsbn(isbn);
        bookService.deleteBookByIsbn(isbn);
        return "deletion of " + bookToDelete + " successful";
    }

}
