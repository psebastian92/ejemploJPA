package com.app.persistencia;

import java.util.List;

import com.app.logica.Artista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ArtistaJpaController {

	// "Fábrica" de conexiones (EntityManagerFactory).
	// Sirve para crear EntityManager, que son los que realmente hablan con la BD.
	private EntityManagerFactory emf = null;

	// En el constructor decimos con qué unidad de persistencia vamos a trabajar.
	// Esa unidad está definida en persistence.xml con el nombre "musicaPU".
	public ArtistaJpaController() {
		emf = Persistence.createEntityManagerFactory("musicaPU");
	}

	// Método que crea y devuelve un nuevo "EntityManager".
	// Pensalo como: "dame un empleado que se conecte a la base para trabajar".
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// Método para guardar un Artista en la base de datos.
	public void crear(Artista art) {
		EntityManager em = null;
		try {
			// Abrimos la conexión (pedimos un empleado).
			em = getEntityManager();

			// Iniciamos una transacción: empieza la "promesa".
			em.getTransaction().begin();

			// Guardamos el objeto en la base (pero todavía no está confirmado).
			em.persist(art);

			// Confirmamos la transacción: ahora sí el objeto queda guardado.
			em.getTransaction().commit();
		} catch (Exception e) {
			// Si algo falla, deshacemos los cambios
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			// Cerramos la conexión (el empleado ya no hace falta).
			if (em != null) {
				em.close();
			}
		}
	}

	public Artista buscarUnoSolo(int id) {
		EntityManager em = null;

		try {
			// Abrimos la conexión (pedimos un empleado).
			em = getEntityManager();
			// Se busca un artista en la BD con el ID que viene desde el main
			Artista art = em.find(Artista.class, id);

			// La función es del tipo "Artista", por lo que generará un "Artista" como dato
			return art;
		} 
		
		finally {
			if (em != null) {
				em.close();
			}
		}

	}

	public List<Artista> buscarTodos() {
		EntityManager em = getEntityManager();
		try {
			String jpql = "SELECT a FROM " + Artista.class.getSimpleName() + " a";
			return em.createQuery(jpql, Artista.class).getResultList();
		} finally {
			em.close();
		}
	}

	public void destruir(int id) {
		EntityManager em = null;
		try {
			// Abrimos la conexión (pedimos un empleado).
			em = getEntityManager();

			// Iniciamos una transacción: empieza la "promesa".
			em.getTransaction().begin();

			// Se busca un artista con el ID que viene desde el main
			Artista art = em.find(Artista.class, id);

			// Si el artista existe, se solicitará que sea borrado
			if (art != null) {
				em.remove(art);
			}
			// Confirmamos la transacción
			em.getTransaction().commit();
			System.out.println("Artista elimnado con éxito!");
		} finally {
			// Cerramos la conexión (el empleado ya no hace falta).
			if (em != null) {
				em.close();
			}
		}
	}

	public void editar(Artista art) {
		EntityManager em = null;

		try {
			// Abrimos la conexión (pedimos un empleado).
			em = getEntityManager();

			// Iniciamos una transacción: empieza la "promesa".
			em.getTransaction().begin();

			// Se solicitará la edición
			em.merge(art);

			// Confirmamos la transacción
			em.getTransaction().commit();
		} finally {
			// Cerramos la conexión (el empleado ya no hace falta).
			if (em != null) {
				em.close();
			}
		}

	}

}
