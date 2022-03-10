package at.htl.workloads.order.logic;

import at.htl.workloads.order.Orderr;
import at.htl.workloads.order.RevenueRecord;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderrRepoImp implements OrderrRepo {

    private final EntityManager entityManager;

    public OrderrRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Orderr orderr) {
        entityManager.persist(orderr);
    }

    @Override
    public void update(Orderr orderr) {entityManager.persist(orderr);}

    @Override
    public Orderr get(long id) {
        TypedQuery<Orderr> query= entityManager
                .createQuery("select o from Orderr o where o.orderNo = :id", Orderr.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public boolean deleteOrder(long id) {
        int response = entityManager
                .createQuery("delete from Orderr o where o.orderNo = :id")
                .setParameter("id", id)
                .executeUpdate();
        return response == 1;
    }

    @Override
    public List<Object[]> getAllTotalRevenue() {
        List<Object[]> result = this.entityManager
                .createQuery("select new at.htl.workloads.order.RevenueRecord(p.id, concat(p.firstName, concat(' ', p.lastName) ) , sum(oi.PPrice * oi.Amount)) from Person p, OrderItem oi where p = oi.id.orderr.person group by p", RevenueRecord.class)
                .getResultStream().map(rr->  new Object[]{rr.personId(), rr.name(), rr.revenue()}).collect(Collectors.toList());
        return result;

        /*ObjectMapper objectMapper = new ObjectMapper();

        TypedQuery<CountTotalRevenue> query = entityManager
                .createQuery("select NEW at.htl.workloads.query.CountTotalRevenue(p.id, sum(oi.PPrice *  oi.Amount)) from OrderItem oi join oi.id.orderr.person p", CountTotalRevenue.class);
        CountTotalRevenue countTotalRevenueResult = query.getResultStream().findFirst().orElse(null);

        System.out.println("###############" + countTotalRevenueResult.personId() +"  "+  countTotalRevenueResult.totalPrice());

        return objectMapper.convertValue(countTotalRevenueResult, Map.class);*/
    }
}