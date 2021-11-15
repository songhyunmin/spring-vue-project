package vuejs.spring.domain;

import lombok.Data;

@Data
public class Person {

    private Long id, age, corePid;
    private String name, mobileNum, telNum, regDate, gender, solar, birth, coreRelative, addr, addrDetail;
    private String range1, range2, range3, g, youth, school;

    public Person(Long id, Long age, Long corePid, String name, String mobileNum, String telNum, String regDate, String gender, String solar, String birth, String coreRelative, String addr, String addrDetail, String range1, String range2, String range3, String g, String youth, String school) {
        this.id = id;
        this.age = age;
        this.corePid = corePid;
        this.name = name;
        this.mobileNum = mobileNum;
        this.telNum = telNum;
        this.regDate = regDate;
        this.gender = gender;
        this.solar = solar;
        this.birth = birth;
        this.coreRelative = coreRelative;
        this.addr = addr;
        this.addrDetail = addrDetail;
        this.range1 = range1;
        this.range2 = range2;
        this.range3 = range3;
        this.g = g;
        this.youth = youth;
        this.school = school;
    }
}
