package at.htl.workloads.person;

import at.htl.workloads.hobby.Hobby;
import at.htl.workloads.order.Orderr;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person getPerson(Long id);
    void addHobby(Person person, Hobby hobby, boolean amateur);
    Person addPerson(String firstName, String lastName, LocalDate dateOfBirth, Gender gender);

    long numberOfOrders(long id);
}
