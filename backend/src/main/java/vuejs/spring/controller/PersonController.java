package vuejs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vuejs.spring.domain.Duty;
import vuejs.spring.domain.Person;
import vuejs.spring.service.PersonService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public HashMap<String, Object> personList(String pos, String duty1, String duty2) throws Exception {
        List<Person> person = personService.personList(pos, duty1, duty2);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("data", person);
        map.put("total", person.size());

        return map;
    }

    @GetMapping("/search")
    public HashMap<String, Object> personSearch(String keyword) throws Exception {
        List<Person> person = personService.personSearch(keyword);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("data", person);
        map.put("total", person.size());

        return map;
    }

    @GetMapping("/duty/{pos}")
    public HashMap<String, Object> dutyList(@PathVariable("pos") String pos) {
        List<Duty> dutyList = personService.dutyList(pos);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("data", dutyList);
        map.put("total", dutyList.size());

        return map;
    }

    @GetMapping("/person/{id}")
    public Optional<Person> personView(@PathVariable("id") Long id) throws Exception {
        Optional<Person> personView = personService.personView(id);

        return personView;
    }

    @GetMapping("/family/{id}")
    public HashMap<String, Object> familyList(@PathVariable("id") Long id) {
        List<Person> familyList = personService.familyList(id);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("data", familyList);
        map.put("total", familyList.size());

        return map;
    }
}
