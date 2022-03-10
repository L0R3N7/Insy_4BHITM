package at.htl.workloads.person;

import java.util.List;

public interface PersonRepo {
    List<Person> getAll();
    Person getPerson(Long id);
    void update(Person person);
    void add(Person p);

    long getCountAwesomeness();
}
