package vuejs.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import vuejs.spring.domain.Duty;
import vuejs.spring.domain.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MybatisPersonRepository implements PersonRepository {

    private String ns = "mapper.person.";

    @Autowired
    SqlSession session;

    @Override
    public List<Person> personList(String pos, String duty1, String duty2) {
        String gubun = "cvname";
        String column = "cvname";
        String sex = "";

        switch (pos) {
            case "005":
                sex = "남";
                break;
            case "006":
                sex = "여";
                break;
            case "007":
                column = "youth";
                break;
            case "008":
                column = "school";
                break;
            case "009":
                column = "g";
                break;
            case "010":
                sex = "남";
                break;
            case "011":
                sex = "여";
                break;
            default:
                break;
        }

        Map<String, String> map = new HashMap<String, String>();

        map.put("gubun", gubun);
        map.put("column", column);
        map.put("sex", sex);
        map.put("duty1", duty1);
        map.put("duty2", duty2);

        return session.selectList(ns + "personList", map);
    }

    @Override
    public List<Person> personSearch(String keyword) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("keyword", keyword);

        return session.selectList(ns + "personSearch", map);
    }

    @Override
    public List<Duty> dutyList(String pos) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("pos", pos);

        return session.selectList(ns + "dutyList", map);
    }

    @Override
    public Optional<Person> personView(int id) {
        return Optional.ofNullable(getPerson(id));
    }

    @Override
    public Person getPerson(int id) {
        return session.selectOne(ns + "getPerson", id);
    }

    @Override
    public List<Person> familyList(int id) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("id", id);

        return session.selectList(ns + "familyList", map);
    }

    @Override
    public int updatePerson(Person person) {
        return session.update(ns + "updatePerson", person);
    }
}
