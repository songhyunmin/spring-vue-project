package vuejs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vuejs.spring.domain.Menu;
import vuejs.spring.service.MenuService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {
    
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
        System.out.println("menuService.getClass() = " + menuService.getClass());
    }

    @GetMapping("/menu/list")
    public HashMap<String, Object>  menuList() throws Exception {
        //List<Menu> menu = new ArrayList<>();
        //menu.add(new Menu("교역자","/sub/001","/images/main/menu1.png"));
        List<Menu> menu = menuService.menuList();

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("data", menu);
        map.put("total", menu.size());

        return map;
    }
}
