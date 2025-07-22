package com.ramiro.persistence;

import com.ramiro.model.Perro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class PerroJpaController implements Serializable {
    private EntityManagerFactory emf = null;

    public PerroJpaController() {
        this.emf = Persistence.createEntityManagerFactory("AmidogPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Perro perro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(perro);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(Perro perro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(perro);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perro perro = em.find(Perro.class, id);
            if (perro != null) em.remove(perro);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public Perro findPerro(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Perro.class, id);
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Perro> findPerroEntities() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Perro> query = em.createQuery("select p from Perro p", Perro.class);
            return query.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }

    public void deleteAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Perro").executeUpdate();
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }
}
