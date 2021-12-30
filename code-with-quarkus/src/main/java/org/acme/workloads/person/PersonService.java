package org.acme.workloads.person;

import org.acme.workloads.hobbies.Hobby;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getPerson(Long id);

    void addHobby(Person person, Hobby hobby, Boolean amateur);

    Person addPerson(String firsName, String lastName, LocalDate dateOfBirth, Gender gender);

    void removeHobby(Person p, Hobby hobby);
}
