package at.htl.workloads.order.logic;

import at.htl.workloads.order.Orderr;

import java.util.List;

public interface OrderrRepo {
    void add(Orderr orderr);

    Orderr get(long id);

    void update(Orderr orderr);

    boolean deleteOrder(long id);

    List<Object[]> getAllTotalRevenue();
}
