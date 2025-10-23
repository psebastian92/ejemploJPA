package com.app.servlets;

import java.io.IOException;
import com.app.logica.Artista;
import com.app.logica.Cancion;
import com.app.logica.ControladoraLogica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCancionEditar", urlPatterns = { "/SvCancionEditar" })
public class SvCancionEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ControladoraLogica control = new ControladoraLogica();

	// Muestra los datos en un formulario de edición
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Cancion can = control.buscarUnaCancion(id);
		
		request.setAttribute("can", can);
		request.getRequestDispatcher("vistas/editarCancion.jsp").forward(request, response);
		
		
	}

	// Actualiza los datos
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("nombre");
		float duracion = Float.parseFloat(request.getParameter("duracion"));
		int anio = Integer.parseInt(request.getParameter("anio"));

		Cancion can = control.buscarUnaCancion(id);
		can.setTitulo(titulo);
		can.setDuracion(duracion);
		can.setAnio(anio);
		
		try {
			control.editarCancion(can);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		response.sendRedirect("SvArtistaListar");
	}
}
