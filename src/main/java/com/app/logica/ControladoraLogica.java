package com.app.logica;

import java.util.List;

import com.app.persistencia.ControladoraPersistencia;

public class ControladoraLogica {

	// La controladora de persistencia se encarga de hablar con la BD.
	// Desde aqu� la usamos como "puente" para guardar datos.
	ControladoraPersistencia controlPersis = new ControladoraPersistencia();

	// ----- ARTISTA -----
	// M�todo de la capa l�gica para crear un artista.
	// Antes de guardarlo en la BD, se hacen validaciones.
	public void crearArtista(Artista art) throws Exception {
		// Validaci�n: el artista debe tener un nombre
		if (art.getNombre() == null || art.getNombre().isEmpty()) {
			throw new Exception("El artista debe tener un nombre.");
		}
		// Validaci�n: el artista debe tener un g�nero musical
		if (art.getGeneroMusical() == null || art.getGeneroMusical().isEmpty()) {
			throw new Exception("El artista debe tener un g�nero musical.");
		}
		
		// Validaci�n: el artista debe tener una nacionalidad
		if (art.getNacionalidad() == null || art.getNacionalidad().isEmpty()) {
			throw new Exception("El artista debe tener una nacionalidad.");
		}
		
		// Validaci�n: la edad debe ser positiva
		if (art.getEdad() <= 0) {
			throw new Exception("La edad del artista debe ser mayor a 0.");
		} else if (art.getEdad()  > 120) {
			throw new Exception("La edad del artista debe ser menor a 120.");
		}

		// Si pasa todas las validaciones, reci�n ah� se manda a la persistencia
		controlPersis.crearArtista(art);
	}

	// M�todo de la capa l�gica para buscar UN artista.
	// se solicita el ID como par�metro
	public Artista buscarUnArtista(int id) {

		return controlPersis.buscarArtista(id);

	}

	// M�todo de la capa l�gica para buscar TODOS los artista.
	public List<Artista> listarArtistas() {
		return controlPersis.buscarTodosLosArtistas();
	}

	// M�todo de la capa l�gica para eliminar un artista.
	// se solicita el ID como par�metro
	public void eliminarArtista(int id) throws Exception {

		// Primero, hay que buscar en la BD que exista ese elemento
		Artista art = controlPersis.buscarArtista(id);

		// Si el artista es nulo (no existe), lanzar excepci�n (error).
		if (art == null) {
			throw new Exception("No existe un artista con ID " + id);
		}
		// Si existe, ah� si se puede continuar con la eliminaci�n
		controlPersis.eliminarArtista(id);
	}

	// M�todo de la capa l�gica para eliminar un artista.
	// se solicita el ID como par�metro
	public void editarArtista(Artista art) throws Exception {
		// Verificar que exista en BD antes de editar
		Artista existente = controlPersis.buscarArtista(art.getId());
		if (existente == null) {
			throw new Exception("No existe un artista con ID " + art.getId());
		}

		// Validaci�n: el artista debe tener un nombre
		if (art.getNombre() == null || art.getNombre().isEmpty()) {
			throw new Exception("El artista debe tener un nombre.");
		}
		// Validaci�n: el artista debe tener un g�nero musical
		if (art.getGeneroMusical() == null || art.getGeneroMusical().isEmpty()) {
			throw new Exception("El artista debe tener un g�nero musical.");
		}
		
		// Validaci�n: el artista debe tener una nacionalidad
		if (art.getNacionalidad() == null || art.getNacionalidad().isEmpty()) {
			throw new Exception("El artista debe tener una nacionalidad.");
		}
		// Validaci�n: la edad debe ser positiva
		if (art.getEdad() <= 0) {
			throw new Exception("La edad del artista debe ser mayor a 0.");
		}  else if (art.getEdad()  > 120) {
			throw new Exception("La edad del artista debe ser menor a 120.");
		}

		// Si todo esta OK, ah� si se puede continuar con la eliminaci�n
		controlPersis.editarArtista(art);
	}

	// ----- CANCI�N -----
	// M�todo de la capa l�gica para crear una canci�n.
	// Se valida que tenga datos coherentes antes de persistirla.
	public void crearCancion(Cancion can) throws Exception {
		// Validaci�n: el t�tulo no puede estar vac�o
		if (can.getTitulo() == null || can.getTitulo().isEmpty()) {
			throw new Exception("La canci�n debe tener un t�tulo.");
		}
		// Validaci�n: la duraci�n debe ser mayor a cero
		if (can.getDuracion() <= 0) {
			throw new Exception("La duraci�n debe ser mayor a 0 segundos.");
		}
		// Validaci�n: el a�o debe tener sentido
		if (can.getAnio() < 1900) {
			throw new Exception("El a�o de la canci�n debe ser v�lido.");
		}

		// Si pasa todas las validaciones, se guarda en la base de datos
		controlPersis.crearCancion(can);
	}

}
