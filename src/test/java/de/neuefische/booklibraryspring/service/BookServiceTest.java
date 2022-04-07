package de.neuefische.booklibraryspring.service;

import de.neuefische.booklibraryspring.api.IsbnApi;
import de.neuefische.booklibraryspring.model.Book;
import de.neuefische.booklibraryspring.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {


    BookRepository repo = mock(BookRepository.class);
    private IsbnApi isbnApi = new IsbnApi(WebClient.create("https://my-json-server.typicode.com/Flooooooooooorian/BookApi/"));
    BookService service = new BookService(repo, isbnApi);


    @Test

    void testAddBookByIsbn_successfull (){

        Book actual = service.addBookByIsbn("1");

        Book expected = new Book("1", "Bible", "Me");

        assertEquals(expected, actual);
    }


    @Test
    void getStudentById_whenId1_returnAnton(){
        //GIVEN
        when(repo.getByIsbn("111")).thenReturn(Optional.of(new Book("111", "BookA", "Anna")));

        //WHEN

        Book actual = service.getByIsbn("111");

        //THEN

        Book expected = new Book("111", "BookA", "Anna");
        assertEquals(expected, actual);
        //System.out.println(actual);
        verify(repo).getByIsbn("111");
    }

    @Test
    void getByNameTest (){
        //GIVEN
        when(repo.list()).thenReturn(List.of(new Book("111", "BookA", "Anna"), new Book("222", "BookB", "Berta"), new Book("333", "BookA", "Aaron"), new Book("444", "BookB", "Bernd")));
        //WHEN

        List<Book> actual = service.getBooksByTitle("BookA");
        //THEN

        List<Book> expected = List.of(new Book("111", "BookA", "Anna"),new Book("333", "BookA", "Aaron"));
        assertEquals(expected, actual);
        verify(repo).list();

    }





}