package at.htl.workloads.order.logic;

import at.htl.models.OrderItemDTO;
import at.htl.workloads.order.NewOrderItem;
import at.htl.workloads.order.OrderItem;
import at.htl.workloads.order.Orderr;
import at.htl.workloads.person.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrderrServiceImp implements OrderrService{
    private final OrderrRepo orderrRepo;

    public OrderrServiceImp(OrderrRepo orderrRepo) {
        this.orderrRepo = orderrRepo;
    }

    @Override
    public Orderr addOrder(Person person, List<NewOrderItem> toList) {
        Orderr orderr = Orderr.createOrderr(person, toList);
        orderrRepo.add(orderr);
        return orderr;
    }

    @Override
    public Orderr getOrderr(long id) {
        return orderrRepo.get(id);
    }

    @Override
    public Orderr update(Orderr orderr, List<OrderItemDTO> orderItemDTOList) {
        orderItemDTOList.forEach(
                orderItemDTO -> {
                    orderr.addOrderItem(OrderItem.create(orderr, orderItemDTO.getpCode(), orderItemDTO.getpPrice(), orderItemDTO.getAmount()));
                }
        );
        orderrRepo.update(orderr);
        return orderr;
    }

    @Override
    public boolean deleteOrder(long id) {
        return orderrRepo.deleteOrder(id);
    }

    @Override
    public List<Object[]> getAllTotalRevenue() {
        return this.orderrRepo.getAllTotalRevenue();
    }
}
