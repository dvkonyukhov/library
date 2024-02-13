package ru.dkonyukhov.library.services;

import ru.dkonyukhov.library.models.Book;
import ru.dkonyukhov.library.models.Person;

import java.util.List;
import java.util.UUID;

public interface LibraryRepository {
    List<Person> findAllPersons();
    List<Book> findAllBooks();
    Person  createPerson(String name);
    Person  getPerson(UUID id);
}
