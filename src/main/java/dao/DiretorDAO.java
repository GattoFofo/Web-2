package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Diretor;

public class DiretorDAO {
    public void save(Diretor diretor) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(diretor);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
    }

    public Diretor update(Diretor diretor) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.merge(diretor);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
        return diretor;
    }

    public boolean delete(Diretor diretor) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        diretor = manager.find(Diretor.class, diretor.getId());

        boolean deleted;
        try {
            transaction.begin();
            manager.remove(diretor);
            transaction.commit();
            deleted = manager.find(Diretor.class, diretor.getId()) == null;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }

        return deleted;
    }
}
