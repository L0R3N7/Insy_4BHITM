package workloads.vendingmachine;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class VendingMachineRepositoryImpl implements VendingMachineRepository {

    private final EntityManager entityManager;

    public VendingMachineRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VendingMachine> getAll() {
        var query = this.entityManager
                .createQuery("select v from VendingMachine v"
                        , VendingMachine.class);
        return query.getResultList();
    }

    public List<MostExpensiveProduct1> getMostExpensiveProductPerMachine1(){
        var query = this.entityManager
                .createQuery("select NEW workloads.vendingmachine.MostExpensiveProduct1(v.id, max(p.price)) from VendingMachine v" +
                        " join v.products p" +
                        " group by v", MostExpensiveProduct1.class);
        return query.getResultList();
    }

    public List<MostExpensiveProduct2> getMostExpensiveProductPerMachine2(){
        var query = this.entityManager
                .createQuery("select NEW workloads.vendingmachine.MostExpensiveProduct2(v.id, p.price, p.productCode) from VendingMachine v" +
                        " join v.products p" +
                        " where p.price = (select max(p2.price) from VendingMachine v2 join v2.products p2 where v2.id = v.id)" +
                        " group by v, p", MostExpensiveProduct2.class);
        return query.getResultList();
    }
}
