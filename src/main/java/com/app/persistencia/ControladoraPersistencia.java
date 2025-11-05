package com.app.persistencia;

import java.util.List;

import com.app.logica.Artista;
import com.app.logica.Cancion;
import com.app.logica.PerfilArtista;

public class ControladoraPersistencia {

    // ============================
    //       CONTROLADORES JPA
    // ============================
    ArtistaJpaController artistaJpa = new ArtistaJpaController();
    CancionJpaController cancionJpa = new CancionJpaController();
    PerfilArtistaJpaController perfilJpa = new PerfilArtistaJpaController(); // Nuevo

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
    public void crearCancion(Cancion cancion) {
        cancionJpa.crear(cancion);
    }

    public Cancion buscarCancion(int id) {
        return cancionJpa.buscarUnoSolo(id);
    }

    public List<Cancion> buscarTodasLasCanciones() {
        return cancionJpa.buscarTodos();
    }

    public void editarCancion(Cancion cancion) {
        cancionJpa.editar(cancion);
    }

    public void eliminarCancion(int id) {
        cancionJpa.destruir(id);
    }

    // ============================
    //       PERFIL ARTISTA
    // ============================
    public void crearPerfilArtista(PerfilArtista perfil) {
        perfilJpa.crear(perfil);
    }

    public PerfilArtista buscarPerfilArtista(int id) {
        return perfilJpa.buscarUnoSolo(id);
    }

    public List<PerfilArtista> buscarTodosLosPerfiles() {
        return perfilJpa.buscarTodos();
    }

    public void editarPerfilArtista(PerfilArtista perfil) {
        perfilJpa.editar(perfil);
    }

    public void eliminarPerfilArtista(int id) {
        perfilJpa.destruir(id);
    }
}
