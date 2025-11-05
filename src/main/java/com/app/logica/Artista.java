package com.app.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Artista implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Basic
	private String nombre;
	private String generoMusical;
	private String nacionalidad;
	private int edad;
	
	@OneToOne(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
	private PerfilArtista perfil;

	@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cancion> listaCanciones = new ArrayList<>();

	public Artista() {

	}

	public Artista(String nombre, String generoMusical, String nacionalidad, int edad) {
		super();
		this.nombre = nombre;
		this.generoMusical = generoMusical;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "ARTISTA: \n" + "ID: " + getId() + "\nNombre: " + getNombre() + "\nGenero musical: " + getGeneroMusical()
				+ "\nNacionalidad: " + getNacionalidad() + "\nEdad: " + getEdad();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Cancion> getListaCanciones() {
		return listaCanciones;
	}
	
    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
    
    public PerfilArtista getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilArtista perfil) {
        this.perfil = perfil;
        if (perfil != null) {
            perfil.setArtista(this); // sincroniza ambas entidades
        }
    }


}
