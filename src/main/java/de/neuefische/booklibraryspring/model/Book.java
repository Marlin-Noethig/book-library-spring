package de.neuefische.booklibraryspring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    private String id;
    private String title;
    private String author;

}
