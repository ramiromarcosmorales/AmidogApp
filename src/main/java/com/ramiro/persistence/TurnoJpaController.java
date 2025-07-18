package com.ramiro.persistence;

import com.ramiro.model.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TurnoJpaController {
    private EntityManagerFactory emf = null;

    public TurnoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("AmidogPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(turno);
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
            Turno turno = em.find(Turno.class, id);
            if (turno != null) {
                em.remove(turno);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public Turno findTurno(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Turno.class, id);
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Turno> findTurnoEntities() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t", Turno.class);
            return query.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
