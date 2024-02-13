package ru.dkonyukhov.library.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.dkonyukhov.library.LibraryRepository;
import ru.dkonyukhov.library.models.Book;
import ru.dkonyukhov.library.models.Person;

import java.util.List;
import java.util.UUID;

@Service
public class LibraryRepositoryJdbcTemplateImpl implements LibraryRepository {
    public final JdbcTemplate jdbcTemplate;

    public LibraryRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> findAllPersons() {
        return jdbcTemplate.query("SELECT id, name FROM public.\"Person\"", (rs, rowNum) -> {
            Person person = new Person();
            person.setId(UUID.fromString(rs.getString("id")));
            person.setName(rs.getString("name"));
            return person;
        });
    }

    @Override
    public List<Book> findAllBooks() {
        return jdbcTemplate.query("SELECT id, name, author, \"personId\"  FROM public.\"Book\"", (rs, rowNum) -> {
            Book book = new Book();
            book.setId(UUID.fromString(rs.getString("id")));
            book.setPersonId(UUID.fromString(rs.getString("personId")));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            return book;
        });
    }

    @Override
    public Person createPerson(String name) {
        Person person = new Person(name);
        jdbcTemplate.update("INSERT INTO public.\"Person\" (id, name) VALUES (?, ?)", person.getId(), name);
        return person;
    }

    @Override
    public Person getPerson(UUID id) {
        return jdbcTemplate.query("SELECT id, name  FROM public.\"Person\" where id = ?", (rs, rowNum) -> {
            Person person = new Person();
            person.setId(UUID.fromString(rs.getString("id")));
            person.setName(rs.getString("name"));
            return person;
        }, id).getFirst();
    }
}
