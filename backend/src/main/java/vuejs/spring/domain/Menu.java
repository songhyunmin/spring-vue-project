package vuejs.spring.domain;

import lombok.Data;

@Data
public class Menu {
    private String title;
    private String link;
    private String img;

    public Menu(String title, String link, String img) {
        this.title = title;
        this.link = link;
        this.img = img;
    }
}