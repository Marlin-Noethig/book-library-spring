package de.neuefische.booklibraryspring.api;

import de.neuefische.booklibraryspring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;


@Service
public class IsbnApi {

    private final WebClient webClient;


    @Autowired
    public IsbnApi(WebClient webClient) {
        this.webClient = webClient;
    }




    public Optional<Book> getBookByIsbn(String isbn) {
        return Optional.ofNullable(
                webClient.get()
                .uri("/books/" + isbn)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .toEntity(Book.class)
                .block()
                .getBody()
        );
    }
}
