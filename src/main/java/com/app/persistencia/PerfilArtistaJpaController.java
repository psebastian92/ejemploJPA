package com.app.persistencia;

import java.util.List;

import com.app.logica.PerfilArtista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PerfilArtistaJpaController {

    private EntityManagerFactory emf = null;

    // Constructor: indicamos la unidad de persistencia
    public PerfilArtistaJpaController() {
        emf = Persistence.createEntityManagerFactory("musicaPU");
    }

    // Método para obtener un EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // ===========================
    //          CRUD
    // ===========================

    // CREAR PERFIL ARTISTA
    public void crear(PerfilArtista perfil) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(perfil);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }

    // BUSCAR UN PERFIL ARTISTA POR ID
    public PerfilArtista buscarUnoSolo(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(PerfilArtista.class, id);
        } finally {
            if (em != null) em.close();
        }
    }

    // BUSCAR TODOS LOS PERFILES ARTISTA
    public List<PerfilArtista> buscarTodos() {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT p FROM " + PerfilArtista.class.getSimpleName() + " p";
            return em.createQuery(jpql, PerfilArtista.class).getResultList();
        } finally {
            em.close();
        }
    }

    // EDITAR PERFIL ARTISTA
    public void editar(PerfilArtista perfil) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(perfil);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }

    // ELIMINAR PERFIL ARTISTA
    public void destruir(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            PerfilArtista perfil = em.find(PerfilArtista.class, id);
            if (perfil != null) {
                em.remove(perfil);
            }

            em.getTransaction().commit();
            System.out.println("Perfil de artista eliminado con éxito!");
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }
}
