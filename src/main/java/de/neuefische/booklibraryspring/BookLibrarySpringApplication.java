package de.neuefische.booklibraryspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BookLibrarySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookLibrarySpringApplication.class, args);

    }


    @Bean
    public WebClient getWebClient(){
        return WebClient.create("https://my-json-server.typicode.com/Flooooooooooorian/BookApi/");
    }
}
