package com.app.igu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.logica.Artista;
import com.app.logica.Cancion;
import com.app.logica.ControladoraLogica;
import com.app.persistencia.ControladoraPersistencia;

public class Main {
	public static void main(String[] args) {
		Artista a1 = new Artista("Ciro Martínez", "Rock nacional", "argentino", 57);
		Artista a2 = new Artista("Pity González", "Rock nacional", "argentino", 64);

		Cancion c1 = new Cancion("Paciencia", 5.16f, 2025);
		Cancion c2 = new Cancion("La argentinidad al palo", 5.3f, 2004);

		ControladoraLogica conLog = new ControladoraLogica();
		Scanner entrada = new Scanner(System.in);

		/*----- CREAR UN DATO-------*/
//		try {
//			conLog.crearArtista(a1);
//			conLog.crearArtista(a2);
//			conLog.crearCancion(c1);
//			conLog.crearCancion(c2);
//		} catch (Exception e) {
//			System.out.println("No se pudo crear el elemento: " + e.getMessage());
//		}

		/*----- BUSCAR UN DATO-------*/
//		Artista artEncontrado = conLog.buscarUnArtista(6);
//		System.out.println(artEncontrado);
		
		/*----- BUSCAR TODOS LOS DATOS-------*/
		List<Artista> listaArtistas = conLog.listarArtistas();
		for (Artista artista : listaArtistas) {
			System.out.println(artista);
			System.out.println("-------");
		}

		/*----- ELIMINAR UN DATO-------*/
		System.out.println("\n-------------------");
		try {
			System.out.println("Ingrese dato a eliminar según ID: ");
			conLog.eliminarArtista(entrada.nextInt());
		} catch (Exception e) {
			System.out.println("Error al eliminar: " + e.getMessage());
		}

		/*----- EDITAR UN DATO-------*/
//		System.out.println("Elija un artista a editar, segun la lista anterior: ");
//		int idEditar = entrada.nextInt();
//		Artista artistaEditable = conLog.buscarUnArtista(idEditar);
//
//		if (artistaEditable == null) {
//			System.err.println("No existe un artista con ID " + idEditar);
//			System.err.println("FINALIZANDO PROGRAMA");
//			return; // o volver a pedir el ID
//		}
//
//		System.out.println("¿Qué desea editar?");
//		System.out.println("1. Nombre");
//		System.out.println("2. Género Musical");
//		System.out.println("3. Nacionalidad");
//		System.out.println("4. Edad");
//
//		int opcion = entrada.nextInt();
//		entrada.nextLine(); // limpiar buffer
//
//		switch (opcion) {
//		case 1:
//			System.out.println("Nuevo nombre: ");
//			artistaEditable.setNombre(entrada.nextLine());
//			break;
//		case 2:
//			System.out.println("Nuevo género musical: ");
//			artistaEditable.setGeneroMusical(entrada.nextLine());
//			break;
//		case 3:
//			System.out.println("Nueva nacionalidad: ");
//			artistaEditable.setNacionalidad(entrada.nextLine());
//			break;
//		case 4:
//			System.out.println("Nueva edad: ");
//			artistaEditable.setEdad(entrada.nextInt());
//			break;
//		default:
//			System.out.println("Opción inválida.");
//		}
//
//		try {
//			conLog.editarArtista(artistaEditable);
//		} catch (Exception e) {
//			System.err.println("ERROR!: " + e.getMessage());
//			System.err.println("PROGRAMA FINALIZADO");
//			return;
//		}
//
//		// Se vuelve a buscar al artista editado en la BD
//		Artista editado = conLog.buscarUnArtista(idEditar);
//		System.out.println("-----------");
//		System.out.println("ARTISTA EDITADO: \n" + editado);

	}
}
