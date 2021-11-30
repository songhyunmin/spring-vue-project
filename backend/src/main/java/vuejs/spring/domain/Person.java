package vuejs.spring.domain;

import lombok.Data;

@Data
public class Person {
    private int id;
    private String name;
    private Integer age;
    private String mobileNum;
    private String telNum;
    private String gender;
    private String core;
    private String birth;
    private String solar;
    private Integer corePid;
    private String coreRelative;
    private String duty1;
    private String duty2;
    private String addr;
    private String addrDetail;
    private String range1;
    private String range2;
    private String range3;
    private String regDate;
    private String school;
    private String youth;
    private String g;

    public Person(int id, String name, Integer age, String mobileNum, String telNum, String gender, String core, String birth, String solar, Integer corePid, String coreRelative, String duty1, String duty2, String addr, String addrDetail, String range1, String range2, String range3, String regDate, String school, String youth, String g) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobileNum = mobileNum;
        this.telNum = telNum;
        this.gender = gender;
        this.core = core;
        this.birth = birth;
        this.solar = solar;
        this.corePid = corePid;
        this.coreRelative = coreRelative;
        this.duty1 = duty1;
        this.duty2 = duty2;
        this.addr = addr;
        this.addrDetail = addrDetail;
        this.range1 = range1;
        this.range2 = range2;
        this.range3 = range3;
        this.regDate = regDate;
        this.school = school;
        this.youth = youth;
        this.g = g;
    }
}
