package workloads.vendingmachine;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class VendingMachineServiceImpl implements VendingMachineService {

    private final VendingMachineRepository repository;

    public VendingMachineServiceImpl(VendingMachineRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VendingMachine> getAll() {
        return this.repository.getAll();
    }

}
