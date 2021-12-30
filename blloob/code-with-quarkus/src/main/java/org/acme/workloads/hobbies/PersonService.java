package org.acme.workloads.hobbies;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getPerson(Long id);

    void addHobby(Person person, String HobbyDescription, Boolean outdoor);

    Person addPerson(String firsName, String lastName, LocalDate dateOfBirth, Gender gender);

    void removeHobby(Person p, Hobby hobby);
}
