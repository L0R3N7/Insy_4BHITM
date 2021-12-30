package at.htl.workloads.person;

import at.htl.workloads.hobby.Hobby;

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
        person.addInterest(hobby, amateur);
        this.personRepo.update(person);
    }

    @Override
    public Person addPerson(String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        var p = Person.create(firstName, lastName, dateOfBirth, gender);
        this.personRepo.add(p);
        return p;
    }
}
