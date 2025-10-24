package com.app.persistencia;

import java.util.List;

import com.app.logica.Artista;
import com.app.logica.Cancion;

public class ControladoraPersistencia {

	// ============================
	//       CONTROLADORES JPA
	// ============================
	ArtistaJpaController artistaJpa = new ArtistaJpaController();
	CancionJpaController cancionJpa = new CancionJpaController();

	// ============================
	//          ARTISTA
	// ============================

	public void crearArtista(Artista artista) {
		artistaJpa.crear(artista);
	}

	public Artista buscarArtista(int id) {
		return artistaJpa.buscarUnoSolo(id);
	}

	public List<Artista> buscarTodosLosArtistas() {
		return artistaJpa.buscarTodos();
	}

	public void eliminarArtista(int id) {
		artistaJpa.destruir(id);
	}

	public void editarArtista(Artista art) {
		artistaJpa.editar(art);
	}

	// ============================
	//          CANCIÓN
	// ============================

	// CREAR CANCIÓN
	public void crearCancion(Cancion cancion) {
		cancionJpa.crear(cancion);
	}

	// BUSCAR UNA CANCIÓN POR ID
	public Cancion buscarCancion(int id) {
		return cancionJpa.buscarUnoSolo(id);
	}

	// BUSCAR TODAS LAS CANCIONES
	public List<Cancion> buscarTodasLasCanciones() {
		return cancionJpa.buscarTodos();
	}

	// EDITAR CANCIÓN
	public void editarCancion(Cancion cancion) {
		cancionJpa.editar(cancion);
	}

	// ELIMINAR CANCIÓN
	public void eliminarCancion(int id) {
		cancionJpa.destruir(id);
	}

}
