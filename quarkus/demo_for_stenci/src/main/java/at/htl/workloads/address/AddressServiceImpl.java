package at.htl.workloads.address;


import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AddressServiceImpl implements AddressService{

    private final AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address addAddress(String Street, int StreetNr, int Post, String city){
        Address address = Address.create(Street, StreetNr, Post, city);
        addressRepo.add(address);
        return address;
    }

    @Override
    public Address getAddress(long aid) {
        return addressRepo.getAddress(aid);
    }

    @Override
    public List<String> getAllCities() {
        return addressRepo.getAllCities();
    }
}
