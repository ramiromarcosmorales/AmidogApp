package com.ramiro.persistence;

import com.ramiro.model.Propietario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class PropietarioJpaController implements Serializable {
    private EntityManagerFactory emf = null;

    public PropietarioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("AmidogPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Propietario propietario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(propietario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Propietario propietario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(propietario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Propietario propietario = em.find(Propietario.class, id);
            if (propietario != null) {
                em.remove(propietario);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Propietario findPropietario(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Propietario.class, id);
        } finally {
            em.close();
        }
    }

    public List<Propietario> findPropietarioEntities() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Propietario> query = em.createQuery("SELECT p FROM Propietario p", Propietario.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
