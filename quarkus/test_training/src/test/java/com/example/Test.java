package com.example;

import com.example.workloads.VendingMachine.logik.VendingMachineRepoImpl;
import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@QuarkusTest
public class Test {

    @Inject
    private EntityManager entityManager;

    @org.junit.jupiter.api.Test
    public void foo(){
        var repo = new VendingMachineRepoImpl(entityManager);

        repo.getMostExpensiveProduct();
    }
}
