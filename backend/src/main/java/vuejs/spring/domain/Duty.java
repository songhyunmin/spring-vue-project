package vuejs.spring.domain;

import lombok.Data;

@Data
public class Duty {

    private String name;
    private String name1;

    public Duty(String name, String name1) {
        this.name = name;
        this.name1 = name1;
    }
}
