import com.xzr.entity.Menu;
import com.xzr.service.MenuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by F on 2017/10/24.
 */
public class TestService {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        MenuService bean = context.getBean(MenuService.class);
        List<Menu> menus = bean.queryAll();
        for (Menu menu : menus) {
            System.out.println(menu);
        }

    }
}
