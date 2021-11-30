package vuejs.spring.repository;

import vuejs.spring.domain.Duty;
import vuejs.spring.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<Person> personList(String pos, String duty1, String duty2);
    List<Person> personSearch(String keyword);
    List<Duty> dutyList(String pos);
    Optional<Person> personView(int id);
    Person getPerson(int id);
    List<Person> familyList(int id);
    int updatePerson(Person person);
}
