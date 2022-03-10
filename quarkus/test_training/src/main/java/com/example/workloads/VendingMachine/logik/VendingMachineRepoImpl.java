package com.example.workloads.VendingMachine.logik;

import com.example.api.model.MostExpensiveProduct;
import com.example.workloads.VendingMachine.VendingMachine;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class VendingMachineRepoImpl implements VendingMachineRepo {

    private final EntityManager entityManager;

    public VendingMachineRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VendingMachine> getAll() {
        TypedQuery<VendingMachine> typedQuery = this.entityManager
                .createQuery("select v from VendingMachine v", VendingMachine.class);
        return typedQuery.getResultStream().collect(Collectors.toList());
    }


    public List<MostExpensiveProduct> getMostExpensiveProduct(){
        var query = this.entityManager
                .createQuery("select v, p.price, p.name from VendingMachine v join v.products p where p.price >= all(select max(p2.price) from VendingMachine v2 join v2.products p2 where v2 = v group by v2) group by v, p", Tuple.class);
        var result = query.getResultList();

        return null;
    }

    @Override
    public VendingMachine getById(long id) {
        return this.entityManager.createQuery("select v from VendingMachine v where v.id = :id", VendingMachine.class).setParameter("id", id).getSingleResult());
    }

    @Override
    public void delete(VendingMachine vendingMachine) {
        this.entityManager.remove(vendingMachine);
    }
}
