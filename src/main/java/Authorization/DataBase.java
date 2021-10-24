package Authorization;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static Authorization.User.ROLE.ADMIN;
import static Authorization.User.ROLE.USER;

import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class DataBase implements ServletContextListener {

    public AtomicReference<UserPut> useres;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        useres = new AtomicReference<>(new UserPut());

        useres.get().add(new User("Ruslan", "chunchunmaru", ADMIN));
        useres.get().add(new User("Egor", "amidamaru", ADMIN));
        useres.get().add(new User("Vova", "12345qwerty", ADMIN));
        useres.get().add(new User("Nikita", "NonPlayerCharacter", ADMIN));
        useres.get().add(new User("1", "1", ADMIN));
        useres.get().add(new User("2", "2", USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("useres", useres);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        useres = null;
    }
}