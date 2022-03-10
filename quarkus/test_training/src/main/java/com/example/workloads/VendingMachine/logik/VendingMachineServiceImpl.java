package com.example.workloads.VendingMachine.logik;

import com.example.workloads.VendingMachine.VendingMachine;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class VendingMachineServiceImpl implements VendingMachineService {

    private final VendingMachineRepo vendingMachineRepo;

    public VendingMachineServiceImpl(VendingMachineRepo vendingMachineRepo) {
        this.vendingMachineRepo = vendingMachineRepo;
    }

    @Override
    public List<VendingMachine> getAll() {
        return this.vendingMachineRepo.getAll();
    }

    @Override
    public VendingMachine getById(long id) {
        return this.vendingMachineRepo.getById(id);
    }

    @Override
    public void delete(VendingMachine vendingMachine) {
        this.vendingMachineRepo.delete(vendingMachine);
    }
}
