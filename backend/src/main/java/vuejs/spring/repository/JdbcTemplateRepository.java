package vuejs.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import vuejs.spring.domain.Menu;
import vuejs.spring.domain.Person;
import vuejs.spring.domain.Duty;

import javax.sql.DataSource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateRepository implements MenuRepository, PersonRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Menu> menuList() {
        return jdbcTemplate.query("select * from menu order by ord", menuRowMapper());
    }

    @Override
    public List<Person> personList(String pos, String duty1, String duty2) {
        String whereQry = "";
        String column = "cvname";

        switch (pos) {
            case "001":
                break;
            case "002":
                break;
            case "003":
                break;
            case "004":
                break;
            case "005":
                whereQry = " and gender='남' ";
                break;
            case "006":
                whereQry = " and gender='여' ";
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
                whereQry = " and gender='남' ";
                break;
            case "011":
                whereQry = " and gender='여' ";
                break;
            default:
                break;
        }

        List<Person> result = new ArrayList<>();

        if (column == "cvname")
        {
            result = jdbcTemplate.query("select * from people where duty1 = ? and duty2 = ? " + whereQry + " order by name", personRowMapper(), duty1, duty2);
        }
        else
        {
            result = jdbcTemplate.query("select * from people where " + column + " = ? order by name", personRowMapper(), duty1);
        }

        return result;
    }

    @Override
    public List<Duty> dutyList(String pos) {

        String whereQry = "";

        switch (pos) {
            case "001":
                whereQry = " and gubun = 'cvname' and depth = 2 and name in('목사','전도사','사모','선교사') ";
                break;
            case "002":
                whereQry = " and gubun = 'cvname' and depth = 2 and name in('장로') ";
                break;
            case "003":
                whereQry = " and gubun = 'cvname' and depth = 2 and name in('안수집사') ";
                break;
            case "004":
                whereQry = " and gubun = 'cvname' and depth = 2 and name in('권사') ";
                break;
            case "005":
                whereQry = " and gubun = 'cvname' and depth = 2 and name in('집사') ";
                break;
            case "006":
                whereQry = " and gubun = 'cvname' and depth = 2 and name in('집사') ";
                break;
            case "007":
                whereQry = " and gubun = 'youth' and depth = 1 ";
                break;
            case "008":
                whereQry = " and gubun = 'school' and depth = 1 ";
                break;
            case "009":
                whereQry = " and gubun = 'g' and depth = 1 ";
                break;
            case "010":
                whereQry = " and gubun = 'cvname' and depth = 2 and name in('성도') ";
                break;
            case "011":
                whereQry = " and gubun = 'cvname' and depth = 2 and name in('성도') ";
                break;
            default:
                whereQry = " and gubun = 'pastor' and depth = 2 and name in('목사','전도사','사모','선교사') ";
                break;
        }

        return jdbcTemplate.query("select name,name1 from set_dutys where u>0 " + whereQry + " order by ord1, ord2", dutyRowMapper());
    }

    @Override
    public List<Person> personSearch(String keyword) {
        String whereQry = "";
        if (keyword != "")
        {
            whereQry = MakeSearchQryFirstLetter("name", keyword);
        }
        return jdbcTemplate.query("select * from people where id>0 " + whereQry +" order by name", personRowMapper());
    }

    @Override
    public Optional<Person> personView(Long id) {
        List<Person> result = jdbcTemplate.query("select * from people where id = ?", personRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public List<Person> familyList(Long id) {
        return jdbcTemplate.query("select * from people WHERE corepid IN (SELECT corePid FROM people WHERE id = ? ) order by age desc", personRowMapper(), id);
    }

    private RowMapper<Menu> menuRowMapper() {
        return (rs, rowNum) -> {
            Menu menu = new Menu("","","");
            menu.setTitle(rs.getString("title"));
            menu.setLink(rs.getString("link"));
            menu.setImg(rs.getString("img"));
            return menu;
        };
    }

    private RowMapper<Duty> dutyRowMapper() {
        return (rs, rowNum) -> {
            Duty duty = new Duty(
                rs.getString("name"),
                rs.getString("name1")
            );
            return duty;
        };
    }

    private RowMapper<Person> personRowMapper() {
        return (rs, rowNum) -> {
            Person person = new Person(
                    rs.getLong("id"),
                    rs.getLong("age"),
                    rs.getLong("corePid"),
                    rs.getString("name"),
                    rs.getString("mobileNum"),
                    rs.getString("telNum"),
                    rs.getString("regDate"),
                    rs.getString("gender"),
                    rs.getString("solar"),
                    rs.getString("birth"),
                    rs.getString("coreRelative"),
                    rs.getString("addr"),
                    rs.getString("addrDetail"),
                    rs.getString("range1"),
                    rs.getString("range2"),
                    rs.getString("range3"),
                    rs.getString("g"),
                    rs.getString("youth"),
                    rs.getString("school")
            );
            return person;
        };
    }

    private String MakeSearchQryFirstLetter(String fieldName, String fieldValue) {
        String returnValue = "";
        switch (fieldValue) {
            case "ㄱ":
                returnValue = " and (name RLIKE '^(ㄱ|ㄲ)' OR ( name >= '가' AND name < '나' )) ";
                break;
            case "ㄴ":
                returnValue = " and (name RLIKE '^ㄴ' OR ( name >= '나' AND name < '다' )) ";
                break;
            case "ㄷ":
                returnValue = " and (name RLIKE '^(ㄷ|ㄸ)' OR ( name >= '다' AND name < '라' )) ";
                break;
            case "ㄹ":
                returnValue = " and (name RLIKE '^ㄹ' OR ( name >= '라' AND name < '마' )) ";
                break;
            case "ㅁ":
                returnValue = " and (name RLIKE '^ㅁ' OR ( name >= '마' AND name < '바' )) ";
                break;
            case "ㅂ":
                returnValue = " and (name RLIKE '^ㅂ' OR ( name >= '바' AND name < '사' )) ";
                break;
            case "ㅅ":
                returnValue = " and (name RLIKE '^(ㅅ|ㅆ)' OR ( name >= '사' AND name < '아' )) ";
                break;
            case "ㅇ":
                returnValue = " and (name RLIKE '^ㅇ' OR ( name >= '아' AND name < '자' )) ";
                break;
            case "ㅈ":
                returnValue = " and (name RLIKE '^(ㅈ|ㅉ)' OR ( name >= '자' AND name < '차' )) ";
                break;
            case "ㅊ":
                returnValue = " and (name RLIKE '^ㅊ' OR ( name >= '차' AND name < '카' )) ";
                break;
            case "ㅋ":
                returnValue = " and (name RLIKE '^ㅋ' OR ( name >= '카' AND name < '타' )) ";
                break;
            case "ㅌ":
                returnValue = " and (name RLIKE '^ㅌ' OR ( name >= '타' AND name < '파' )) ";
                break;
            case "ㅍ":
                returnValue = " and (name RLIKE '^ㅍ' OR ( name >= '파' AND name < '하' )) ";
                break;
            case "ㅎ":
                returnValue = " and (name RLIKE '^ㅎ' OR ( name >= '하')) ";
                break;
            default:
                returnValue = " and name like '%" + fieldValue + "%' ";
                break;
        }
        return returnValue;
    }
}
