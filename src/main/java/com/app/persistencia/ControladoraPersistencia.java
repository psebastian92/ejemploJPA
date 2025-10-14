package com.app.persistencia;

import java.util.List;

import com.app.logica.Artista;
import com.app.logica.Cancion;

public class ControladoraPersistencia {
	// Artista: Creamos una instancia del controlador que sabe cómo hablar con la
	// base de datos
	ArtistaJpaController artistaJpa = new ArtistaJpaController();

	// Cancion: Creamos una instancia del controlador que sabe cómo hablar con la
	// base de datos
	CancionJpaController cancionJpa = new CancionJpaController();

	/*-------------ARTISTA----------------*/

	// CREAR ARTISTA: Este método es el que se usa desde otras capas para crear un
	// ARTISTA
	public void crearArtista(Artista artista) {
		// Delegamos la tarea al controlador especializado
		artistaJpa.crear(artista);
	}

	// BUSCAR UN ARTISTA: Este método es el que se usa desde otras capas para buscar
	// un ARTISTA
	public Artista buscarArtista(int id) {

		return artistaJpa.buscarUnoSolo(id);
	}
	
	// BUSCAR TODOS LOS ARTISTAS: Este método es el que se usa desde otras capas para buscar
		// TODOS los ARTISTAS
	public List<Artista> buscarTodosLosArtistas() {
		return artistaJpa.buscarTodos();
	}

	// ELIMINAR ARTISTA: Este método es el que se usa desde otras capas para
	// eliminar un ARTISTA
	public void eliminarArtista(int id) {
		// Delegamos la tarea al controlador especializado
		artistaJpa.destruir(id);

	}
	
	// EDITAR ARTISTA: Este método es el que se usa desde otras capas para
		// editar un ARTISTA
	public void editarArtista(Artista art) {
		artistaJpa.editar(art);
		
	}
	
	
	
	

	/*-------------CANCION----------------*/

	// Este método es el que se usa desde otras capas para crear una CANCION
	public void crearCancion(Cancion cancion) {
		// Delegamos la tarea al controlador especializado
		cancionJpa.crear(cancion);
	}



	

}
