package vuejs.spring.service;

import vuejs.spring.domain.Menu;
import vuejs.spring.repository.MenuRepository;

import java.util.List;

public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> menuList() throws Exception {
        return menuRepository.menuList();
    }
}
