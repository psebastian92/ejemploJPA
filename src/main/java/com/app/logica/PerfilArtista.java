package com.app.logica;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class PerfilArtista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String biografia;
    private String fotoPerfilUrl;
    private String fotoPortadaUrl;
    private int cantSeguidores; // cambié a int

    @OneToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    // ----- Constructores -----
    public PerfilArtista() {
    }

    // Constructor completo
    public PerfilArtista(String biografia, String fotoPerfilUrl, String fotoPortadaUrl, int cantSeguidores) {
        this.biografia = biografia;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.fotoPortadaUrl = fotoPortadaUrl;
        this.cantSeguidores = cantSeguidores;
    }

    // ----- Getters y Setters -----
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    public String getFotoPortadaUrl() {
        return fotoPortadaUrl;
    }

    public void setFotoPortadaUrl(String fotoPortadaUrl) {
        this.fotoPortadaUrl = fotoPortadaUrl;
    }

    public int getCantSeguidores() {
        return cantSeguidores;
    }

    public void setCantSeguidores(int cantSeguidores) {
        this.cantSeguidores = cantSeguidores;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
