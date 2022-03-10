package at.htl.workloads.person;

import at.htl.workloads.order.Orderr;

import java.util.List;

public interface PersonRepo {
    List<Person> getAll();
    Person getPerson(Long id);
    void update(Person person);
    void add(Person p);

    long numberOfOrders(long id);
}
