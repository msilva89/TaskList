package teste;

import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProviderResolverHolder;
import org.hibernate.Session;
import br.com.tasklist.entity.Task;

public class Main {

    public static void main(String[] args) {
        System.out.println(PersistenceProviderResolverHolder.getPersistenceProviderResolver().getPersistenceProviders());

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("testehibernate5");
        EntityManager manager = factory.createEntityManager();

        Session session = manager.unwrap(Session.class);
        Stream<Task> stream = session.createQuery("select a from Autor a").stream();

        manager.close();
        factory.close();
    }
}
