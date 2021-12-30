package org.acme.workloads.hobbies;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonService{

    private final PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo){
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
    public void addHobby(Person person, String HobbyDescription, Boolean outdoor) {
        person.addHobby(HobbyDescription, outdoor);
        this.personRepo.update(person); //wieso updatet man person wenn man hobby added, weil schwache relation hobby, deswegen hobby in person managen durch cascade.all angegeben
    }

    @Override
    public Person addPerson(String firsName, String lastName, LocalDate dateOfBirth, Gender gender) {
        var p = Person.create(firsName, lastName, dateOfBirth, gender);
        this.personRepo.add(p);
        return p;
    }

    @Override
    public void removeHobby(Person p, Hobby hobby) {
        p.removeHobby(hobby);
        this.personRepo.update(p);
    }
}
