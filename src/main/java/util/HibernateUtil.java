package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static Session Session;

    public static Session getHibernateSession() {
        if(Session == null){
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("META-INF/default").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

            SessionFactory factory = metadata.getSessionFactoryBuilder().build();
            Session = factory.openSession();
        }
        return Session;
    }
}
