package com.app.logica;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cancion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Basic
	private String titulo;
	private float duracion;
	private int anio;

	@ManyToOne
	@JoinColumn(name = "artista_id") // FK en la tabla cancion
	private Artista artista;

	public Cancion() {

	}

	public Cancion(String titulo, float duracion, int anio) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.anio = anio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public Artista getArtista() {
	    return artista;
	}

	public void setArtista(Artista artista) {
	    this.artista = artista;
	}

}
