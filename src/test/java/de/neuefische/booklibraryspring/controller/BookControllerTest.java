package de.neuefische.booklibraryspring.controller;

import de.neuefische.booklibraryspring.model.Book;
import de.neuefische.booklibraryspring.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private BookRepository repository;

/*
    @BeforeAll
    public void cleanUp(){
        repository.deleteAll();
    }

 */




    @Test
    void getAllBooks(){

        //given
        Book book1 = new Book("123","test-book-1", "author1");
        Book book2 = new Book("223","test-book-2", "author2");;
        repository.add(book1);
        repository.add(book2);

        //when

        List<Book> actual = webTestClient.get()
                .uri("/book")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(Book.class)
                .returnResult()
                .getResponseBody();

        //then

        List<Book> expected = List.of(
                new Book("123","test-book-1", "author1"),
                new Book("223","test-book-2", "author2")
        );
        assertEquals(expected, actual);


    }

    @Test
    void addBook(){
        //GIVEN
        Book book = new Book("123", "test-book", "author");

        //WHEN

        Book actual = webTestClient.post()
                .uri("/book")
                .bodyValue(book)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();

        //THEN
        Book expected = new Book("123", "test-book", "author");
        assertEquals(expected, actual);

    }


}