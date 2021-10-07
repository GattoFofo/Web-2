package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Ator {
    public void save(model.Ator ator) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("./../persistence");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();

            manager.persist(ator);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
    }
}
