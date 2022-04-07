package de.neuefische.booklibraryspring.service;

import de.neuefische.booklibraryspring.model.Book;
import de.neuefische.booklibraryspring.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    /*
    BookRepository repo = mock(BookRepository.class);
    BookService service = new BookService(repo, isbnApi);


    @Test
    void getStudentById_whenId1_returnAnton(){
        //GIVEN
        when(repo.getByIsbn("1")).thenReturn(new Book("111", "BookA"));

        //WHEN

        Book actual = service.getByIsbn("111");

        //THEN

        Book expected = new Book("111", "BookA");
        assertEquals(expected, actual);
        //System.out.println(actual);
        verify(repo).getByIsbn("111");
    }

    @Test
    void getByNameTest (){
        //GIVEN
        when(repo.list()).thenReturn(List.of(new Book("111", "BookA"), new Book("222", "BookB"), new Book("333", "BookA"), new Book("444", "BookB")));
        //WHEN

        List<Book> actual = service.getBooksByTitle("BookA");
        //THEN

        List<Book> expected = List.of(new Book("111", "BookA"),new Book("333", "BookA"));
        assertEquals(expected, actual);
        verify(repo).list();

    }

     */



}