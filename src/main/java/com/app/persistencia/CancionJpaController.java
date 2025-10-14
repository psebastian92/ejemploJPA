package com.app.persistencia;

import com.app.logica.Cancion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CancionJpaController {
	
	// "F�brica" de conexiones con la base de datos.
	// Nos permite crear EntityManager, que son los que realmente hacen el trabajo.
	private EntityManagerFactory emf = null;

	// En el constructor indicamos qu� unidad de persistencia usar.
	// El nombre "musicaPU" debe coincidir con el que est� en persistence.xml.
	public CancionJpaController() {
		emf = Persistence.createEntityManagerFactory("musicaPU");
	}

	// M�todo que devuelve un nuevo EntityManager (una conexi�n lista para trabajar).
	// Pod�s pensarlo como: "dame un empleado que se conecte a la BD".
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// M�todo para crear (persistir) una Canci�n en la base de datos.
	public void crear(Cancion canc) {
		EntityManager em = null;
		try {
			// Abrimos la conexi�n (traemos al empleado).
			em = getEntityManager();
			
			// Iniciamos la transacci�n (arranca la promesa de que se har� todo o nada).
			em.getTransaction().begin();
			
			// Guardamos el objeto Cancion en la base (todav�a no confirmado).
			em.persist(canc);
			
			// Confirmamos la transacci�n: ahora s�, el dato queda guardado en la BD.
			em.getTransaction().commit();
		} finally {
			// Cerramos la conexi�n si estaba abierta (el empleado termina su turno).
			if (em != null) {
				em.close();
			}
		}
	}
}
