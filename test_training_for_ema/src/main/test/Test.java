import io.quarkus.test.junit.QuarkusTest;
import workloads.vendingmachine.MostExpensiveProduct1;
import workloads.vendingmachine.VendingMachineRepositoryImpl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class Test {

    @Inject
    private EntityManager entityManager;

    @org.junit.jupiter.api.Test
    public void foo(){
        var repo = new VendingMachineRepositoryImpl(entityManager);

        var res1 = repo.getMostExpensiveProductPerMachine1();

        assertThat(res1).isNotEmpty().hasSize(2);

        var res2 = repo.getMostExpensiveProductPerMachine2();

        assertThat(res2).isNotEmpty().hasSize(2);
    }
}
