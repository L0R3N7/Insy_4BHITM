package at.htl.workloads.person;

import at.htl.workloads.address.Address;
import at.htl.workloads.hobbies.Hobby;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {
    
    private final PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public List<Person> getAll() {
       return this.personRepo.getAll();
    }

    @Override
    public Person getPerson(Long id) {
        return this.personRepo.getPerson(id);
    }

    @Override
    public void addHobby(Person person, Hobby hobby, boolean amateur) {
        person.addHobby(hobby, amateur);
        this.personRepo.update(person);
    }

    @Override
    public void addAddress(Person person, Address address) {
        person.addAddress(address);
        this.personRepo.update(person);
    }

    @Override
    public long getCountAwesomeness() {
        return this.personRepo.getCountAwesomeness();
    }

    @Override
    public Person addPerson(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, Boolean isAwesome) {
        var p = Person.create(firstName, lastName, dateOfBirth, gender,isAwesome);
        this.personRepo.add(p);
        return p;
    }

    @Override
    public void removeHobby(Person person, Hobby hobby) {
        // TODO
    }
}
