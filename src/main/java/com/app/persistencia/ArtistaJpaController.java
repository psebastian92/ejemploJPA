package com.app.persistencia;

import java.util.List;

import com.app.logica.Artista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ArtistaJpaController {

	// "F�brica" de conexiones (EntityManagerFactory).
	// Sirve para crear EntityManager, que son los que realmente hablan con la BD.
	private EntityManagerFactory emf = null;

	// En el constructor decimos con qu� unidad de persistencia vamos a trabajar.
	// Esa unidad est� definida en persistence.xml con el nombre "musicaPU".
	public ArtistaJpaController() {
		emf = Persistence.createEntityManagerFactory("musicaPU");
	}

	// M�todo que crea y devuelve un nuevo "EntityManager".
	// Pensalo como: "dame un empleado que se conecte a la base para trabajar".
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// M�todo para guardar un Artista en la base de datos.
	public void crear(Artista art) {
		EntityManager em = null;
		try {
			// Abrimos la conexi�n (pedimos un empleado).
			em = getEntityManager();

			// Iniciamos una transacci�n: empieza la "promesa".
			em.getTransaction().begin();

			// Guardamos el objeto en la base (pero todav�a no est� confirmado).
			em.persist(art);

			// Confirmamos la transacci�n: ahora s� el objeto queda guardado.
			em.getTransaction().commit();
		} catch (Exception e) {
			// Si algo falla, deshacemos los cambios
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			// Cerramos la conexi�n (el empleado ya no hace falta).
			if (em != null) {
				em.close();
			}
		}
	}

	public Artista buscarUnoSolo(int id) {
		EntityManager em = null;

		try {
			// Abrimos la conexi�n (pedimos un empleado).
			em = getEntityManager();
			// Se busca un artista en la BD con el ID que viene desde el main
			Artista art = em.find(Artista.class, id);

			// La funci�n es del tipo "Artista", por lo que generar� un "Artista" como dato
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
			String jpql = "SELECT DISTINCT a FROM Artista a LEFT JOIN FETCH a.listaCanciones";
			TypedQuery<Artista> query = em.createQuery(jpql, Artista.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public void destruir(int id) {
		EntityManager em = null;
		try {
			// Abrimos la conexi�n (pedimos un empleado).
			em = getEntityManager();

			// Iniciamos una transacci�n: empieza la "promesa".
			em.getTransaction().begin();

			// Se busca un artista con el ID que viene desde el main
			Artista art = em.find(Artista.class, id);

			// Si el artista existe, se solicitar� que sea borrado
			if (art != null) {
				em.remove(art);
			}
			// Confirmamos la transacci�n
			em.getTransaction().commit();
			System.out.println("Artista elimnado con �xito!");
		} finally {
			// Cerramos la conexi�n (el empleado ya no hace falta).
			if (em != null) {
				em.close();
			}
		}
	}

	public void editar(Artista art) {
		EntityManager em = null;

		try {
			// Abrimos la conexi�n (pedimos un empleado).
			em = getEntityManager();

			// Iniciamos una transacci�n: empieza la "promesa".
			em.getTransaction().begin();

			// Se solicitar� la edici�n
			em.merge(art);

			// Confirmamos la transacci�n
			em.getTransaction().commit();
		} finally {
			// Cerramos la conexi�n (el empleado ya no hace falta).
			if (em != null) {
				em.close();
			}
		}

	}

}
