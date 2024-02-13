package ru.dkonyukhov.library.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Book {

    private UUID id;
    private String name;
    private String author;
    private UUID personId;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.id = UUID.randomUUID();
    }
}
