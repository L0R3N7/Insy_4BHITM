package at.htl.workloads.order;

import at.htl.workloads.person.Person;

import java.util.List;

public interface OrderrService {
    Orderr addOrder(Person person, List<NewOrderItem> orderItems);
}
