package com.ramiro.persistence;

import com.ramiro.model.Propietario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class PropietarioJpaController implements Serializable {
    private EntityManager getEntityManager() {
        return JpaUtil.getEntityManager();
    }

    public void create(Propietario propietario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(propietario);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
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
            if (em != null) em.close();
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
            if (em != null) em.close();
        }
    }

    public Propietario findPropietario(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Propietario.class, id);
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Propietario> findPropietarioEntities() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Propietario> query = em.createQuery("SELECT p FROM Propietario p", Propietario.class);
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
            em.createQuery("DELETE FROM Turno").executeUpdate();
            em.createQuery("DELETE FROM Propietario").executeUpdate();
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public Propietario findPropietarioConPerros(int id) {
        var em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            var p = em.createQuery(
                    "SELECT p FROM Propietario p LEFT JOIN FETCH p.perros WHERE p.id=:id",
                    Propietario.class
            ).setParameter("id", id).getResultStream().findFirst().orElse(null);
            em.getTransaction().commit();
            return p;
        } finally { em.close(); }
    }
}
