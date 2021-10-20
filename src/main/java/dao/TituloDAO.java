package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Titulo;

public class TituloDAO {
    public void save(Titulo titulo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(titulo);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
    }
    public Titulo update(Titulo titulo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.merge(titulo);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }
        return titulo;
    }
    public boolean delete(Titulo titulo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        titulo = manager.find(Titulo.class, titulo.getId());

        boolean deleted;
        try {
            transaction.begin();
            manager.remove(titulo);
            transaction.commit();
            deleted = manager.find(Titulo.class, titulo.getId()) == null;
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
