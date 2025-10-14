package com.app.logica;

import java.util.List;

import com.app.persistencia.ControladoraPersistencia;

public class ControladoraLogica {

	// La controladora de persistencia se encarga de hablar con la BD.
	// Desde aquí la usamos como "puente" para guardar datos.
	ControladoraPersistencia controlPersis = new ControladoraPersistencia();

	// ----- ARTISTA -----
	// Método de la capa lógica para crear un artista.
	// Antes de guardarlo en la BD, se hacen validaciones.
	public void crearArtista(Artista art) throws Exception {
		// Validación: el artista debe tener un nombre
		if (art.getNombre() == null || art.getNombre().isEmpty()) {
			throw new Exception("El artista debe tener un nombre.");
		}
		// Validación: el artista debe tener un género musical
		if (art.getGeneroMusical() == null || art.getGeneroMusical().isEmpty()) {
			throw new Exception("El artista debe tener un género musical.");
		}
		// Validación: la edad debe ser positiva
		if (art.getEdad() <= 0) {
			throw new Exception("La edad del artista debe ser mayor a 0.");
		}

		// Si pasa todas las validaciones, recién ahí se manda a la persistencia
		controlPersis.crearArtista(art);
	}

	// Método de la capa lógica para buscar UN artista.
	// se solicita el ID como parámetro
	public Artista buscarUnArtista(int id) {

		return controlPersis.buscarArtista(id);

	}

	// Método de la capa lógica para buscar TODOS los artista.
	public List<Artista> listarArtistas() {
		return controlPersis.buscarTodosLosArtistas();
	}

	// Método de la capa lógica para eliminar un artista.
	// se solicita el ID como parámetro
	public void eliminarArtista(int id) throws Exception {

		// Primero, hay que buscar en la BD que exista ese elemento
		Artista art = controlPersis.buscarArtista(id);

		// Si el artista es nulo (no existe), lanzar excepción (error).
		if (art == null) {
			throw new Exception("No existe un artista con ID " + id);
		}
		// Si existe, ahí si se puede continuar con la eliminación
		controlPersis.eliminarArtista(id);
	}

	// Método de la capa lógica para eliminar un artista.
	// se solicita el ID como parámetro
	public void editarArtista(Artista art) throws Exception {
		// Verificar que exista en BD antes de editar
		Artista existente = controlPersis.buscarArtista(art.getId());
		if (existente == null) {
			throw new Exception("No existe un artista con ID " + art.getId());
		}

		// Validación: el artista debe tener un nombre
		if (art.getNombre() == null || art.getNombre().isEmpty()) {
			throw new Exception("El artista debe tener un nombre.");
		}
		// Validación: el artista debe tener un género musical
		if (art.getGeneroMusical() == null || art.getGeneroMusical().isEmpty()) {
			throw new Exception("El artista debe tener un género musical.");
		}
		// Validación: la edad debe ser positiva
		if (art.getEdad() <= 0) {
			throw new Exception("La edad del artista debe ser mayor a 0.");
		}
		// Si todo esta OK, ahí si se puede continuar con la eliminación
		controlPersis.editarArtista(art);
	}

	// ----- CANCIÓN -----
	// Método de la capa lógica para crear una canción.
	// Se valida que tenga datos coherentes antes de persistirla.
	public void crearCancion(Cancion can) throws Exception {
		// Validación: el título no puede estar vacío
		if (can.getTitulo() == null || can.getTitulo().isEmpty()) {
			throw new Exception("La canción debe tener un título.");
		}
		// Validación: la duración debe ser mayor a cero
		if (can.getDuracion() <= 0) {
			throw new Exception("La duración debe ser mayor a 0 segundos.");
		}
		// Validación: el año debe tener sentido
		if (can.getAnio() < 1900) {
			throw new Exception("El año de la canción debe ser válido.");
		}

		// Si pasa todas las validaciones, se guarda en la base de datos
		controlPersis.crearCancion(can);
	}

}
