package at.htl.workloads.person;

import at.htl.workloads.address.Address;
import at.htl.workloads.hobbies.Hobby;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getPerson(Long id);
    void addHobby(Person person, Hobby hobby, boolean amateur);
    Person addPerson(String firstName, String lastName, LocalDate dateOfBirth, Gender gender,Boolean isAwesome);
    void removeHobby(Person person, Hobby hobby);

    void addAddress(Person person, Address address);

    long getCountAwesomeness();
}
