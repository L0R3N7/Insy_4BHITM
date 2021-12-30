package at.htl.workloads.address;

import java.util.List;

public interface AddressRepo {
    public void add(Address address);

    Address getAddress(long aid);

    List<String> getAllCities();
}
