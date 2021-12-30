package at.htl.workloads.address;


import java.util.List;

public interface AddressService {
    Address addAddress(String Street, int StreetNr, int Post, String city);

    Address getAddress(long aid);

    List<String> getAllCities();
}
