package ru.dkonyukhov.library.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dkonyukhov.library.models.Book;
import ru.dkonyukhov.library.services.LibraryRepository;
import ru.dkonyukhov.library.models.Person;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class LibraryController {
    private final LibraryRepository libraryRepository;
    public LibraryController(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }
    @GetMapping("/persons")
    public List<Person> persons(){
        return libraryRepository.findAllPersons();
    }

    @GetMapping("/books")
    public List<Book> books(){
        return libraryRepository.findAllBooks();
    }

    @PostMapping("/createPerson")
    public Person createPerson(@RequestParam("name") String name){
        return libraryRepository.createPerson(name);
    }

    @GetMapping("/persons/{id}")
    public Person createPerson(@PathVariable UUID id){
        return libraryRepository.getPerson(id);
    }

}
