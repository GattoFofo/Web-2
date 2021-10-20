package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Classe;

public class ClasseDAO {
    public void save(Classe classe) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(classe);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
    }

    public Classe update(Classe classe) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.merge(classe);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
        return classe;
    }

    public Boolean delete(Classe classe) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        classe = manager.find(Classe.class, classe.getId());

        boolean deleted;
        try {
            transaction.begin();
            manager.remove(classe);
            transaction.commit();
            deleted = manager.find(Classe.class, classe.getId()) == null;
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
