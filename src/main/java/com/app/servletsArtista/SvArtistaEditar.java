package com.app.servletsArtista;

import java.io.IOException;
import com.app.logica.Artista;
import com.app.logica.ControladoraLogica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEditarArtista", urlPatterns = { "/SvEditarArtista" })
public class SvArtistaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ControladoraLogica control = new ControladoraLogica();

	// Muestra los datos en un formulario de edición
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Artista art = control.buscarUnArtista(id);
		
		request.setAttribute("art", art);
		request.getRequestDispatcher("vistas/editarArtista.jsp").forward(request, response);
		
		
	}

	// Actualiza los datos
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String genero = request.getParameter("genero");
		String nacionalidad = request.getParameter("nacionalidad");
		int edad = Integer.parseInt(request.getParameter("edad"));


		
		Artista art = control.buscarUnArtista(id);
		art.setNombre(nombre);
		art.setGeneroMusical(genero);
		art.setNacionalidad(nacionalidad);
		art.setEdad(edad);

		try {
			control.editarArtista(art);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		response.sendRedirect("SvArtistaListar");
	}
}
