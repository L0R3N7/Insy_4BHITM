package at.htl.unit;

import at.htl.workloads.address.AddressRepo;
import at.htl.workloads.address.AddressRepoImpl;
import io.quarkus.test.TestTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@TestTransaction
public class AddressRepoTest {
    @Inject
    AddressRepo addressRepo;

    @Test
    public void testGetAddress(){
        Assertions.assertEquals("Limesstraße", addressRepo.getAddress(1).getStreet());
    }
}
