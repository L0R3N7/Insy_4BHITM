package at.htl.workloads.order;

import at.htl.workloads.person.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ApplicationScoped
@Named
public class OrderrServiceImpl implements OrderrService {

    @Inject
    @Default
    private OrderrRepo orderrRepo;

    @Override
    public Orderr addOrder(Person person, List<NewOrderItem> orderItems) {
        Orderr orderr = Orderr.createOrderr(person, orderItems);
        orderrRepo.add(orderr);
        return orderr;
    }

}
