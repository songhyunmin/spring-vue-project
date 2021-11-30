package vuejs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vuejs.spring.dao.TestDAO;
import vuejs.spring.domain.Duty;
import vuejs.spring.domain.Person;
import vuejs.spring.dto.TestDTO;
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
/*
    @Autowired
    private TestDAO testDAO;

    @GetMapping("/hello")
    public List<TestDTO> HelloWorld() {
        return testDAO.getTestData();
    }
*/
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
    public Optional<Person> personView(@PathVariable("id") int id) throws Exception {
        Optional<Person> personView = personService.personView(id);

        return personView;
    }

    @GetMapping("/family/{id}")
    public HashMap<String, Object> familyList(@PathVariable("id") int id) {
        List<Person> familyList = personService.familyList(id);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("data", familyList);
        map.put("total", familyList.size());

        return map;
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") int id, @RequestBody Person person) {
        String resultValue = "";

        try {
            int cnt = personService.updatePerson(person);
            resultValue = "success";
        }
        catch (Exception ex) {
            resultValue = "error";
        }

        return resultValue;
    }
}
