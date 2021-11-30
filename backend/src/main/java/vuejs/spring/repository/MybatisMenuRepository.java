package vuejs.spring.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import vuejs.spring.domain.Menu;

import java.util.List;

public class MybatisMenuRepository implements MenuRepository {

    private String ns = "mapper.menu.";

    @Autowired
    SqlSession session;

    @Override
    public List<Menu> menuList() {
        return session.selectList(ns + "menuList");
    }
}
