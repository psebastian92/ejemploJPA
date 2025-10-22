package com.app.servlets;

import java.io.IOException;
import com.app.logica.ControladoraLogica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminarArtista", urlPatterns = { "/SvEliminarArtista" })
public class SvArtistaEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ControladoraLogica control = new ControladoraLogica();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			control.eliminarArtista(id);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
		}
		response.sendRedirect("SvArtistaListar"); // recarga la lista
	}
}
