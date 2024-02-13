package ru.dkonyukhov.library.models;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Person {
    private UUID id;
    private String name;

    public Person(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }
}
