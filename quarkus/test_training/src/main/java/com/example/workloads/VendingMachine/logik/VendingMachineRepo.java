package com.example.workloads.VendingMachine.logik;

import com.example.workloads.VendingMachine.VendingMachine;

import java.util.List;

public interface VendingMachineRepo {
    List<VendingMachine> getAll();

    VendingMachine getById(long id);

    void delete(VendingMachine vendingMachine);
}
