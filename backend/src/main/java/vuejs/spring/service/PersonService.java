package vuejs.spring.service;

import vuejs.spring.domain.Duty;
import vuejs.spring.domain.Person;
import vuejs.spring.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> personList(String pos, String duty1, String duty2) {
        return personRepository.personList(pos, duty1, duty2);
    }

    public List<Person> personSearch(String keyword) {
        return personRepository.personSearch(keyword);
    }

    public List<Duty> dutyList(String pos) {
        return personRepository.dutyList(pos);
    }

    public Optional<Person> personView(Long id) {
        return personRepository.personView(id);
    }

    public List<Person> familyList(Long id) {
        return personRepository.familyList(id);
    }
}
