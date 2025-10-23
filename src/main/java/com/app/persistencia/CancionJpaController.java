package com.app.persistencia;

import java.util.List;

import com.app.logica.Cancion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CancionJpaController {

    // "Fábrica" de conexiones con la base de datos.
    // Nos permite crear EntityManager, que son los que realmente hacen el trabajo.
    private EntityManagerFactory emf = null;

    // En el constructor indicamos qué unidad de persistencia usar.
    // El nombre "musicaPU" debe coincidir con el que está en persistence.xml.
    public CancionJpaController() {
        emf = Persistence.createEntityManagerFactory("musicaPU");
    }

    // Método que devuelve un nuevo EntityManager (una conexión lista para trabajar).
    // Podés pensarlo como: "dame un empleado que se conecte a la BD".
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // ====================================================
    //                  MÉTODOS CRUD
    // ====================================================

    // CREAR CANCIÓN
    public void crear(Cancion canc) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(canc);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // BUSCAR UNA CANCIÓN POR ID
    public Cancion buscarUnoSolo(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Cancion.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // BUSCAR TODAS LAS CANCIONES
    public List<Cancion> buscarTodos() {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT c FROM " + Cancion.class.getSimpleName() + " c";
            return em.createQuery(jpql, Cancion.class).getResultList();
        } finally {
            em.close();
        }
    }

    // EDITAR CANCIÓN
    public void editar(Cancion canc) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(canc);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // ELIMINAR CANCIÓN
    public void destruir(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Cancion canc = em.find(Cancion.class, id);
            if (canc != null) {
                em.remove(canc);
            }

            em.getTransaction().commit();
            System.out.println("Canción eliminada con éxito!");
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
