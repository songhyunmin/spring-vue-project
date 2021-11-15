package vuejs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vuejs.spring.repository.*;
import vuejs.spring.service.MenuService;
import vuejs.spring.service.PersonService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Bean
    public MenuService memberService(){
        return new MenuService(menuRepository());
    }

    @Bean
    public PersonService personService(){
        return new PersonService(personRepository());
    }

    @Bean
    public MenuRepository menuRepository() {
        return new JdbcTemplateRepository(dataSource);
    }

    @Bean
    public PersonRepository personRepository() {
        return new JdbcTemplateRepository(dataSource);
    }
}

