package at.htl.workloads.order.logic;

import at.htl.models.OrderItemDTO;
import at.htl.workloads.order.NewOrderItem;
import at.htl.workloads.order.Orderr;
import at.htl.workloads.person.Person;

import java.util.List;

public interface OrderrService {
    Orderr addOrder(Person person, List<NewOrderItem> toList);

    Orderr getOrderr(long id);

    Orderr update(Orderr orderr, List<OrderItemDTO> orderItemDTOList);

    boolean deleteOrder(long id);
}
