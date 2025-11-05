package com.app.servletsPerfil;

import java.io.IOException;
import com.app.logica.ControladoraLogica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvPerfilEliminar", urlPatterns = { "/SvPerfilEliminar" })
public class SvPerfilEliminar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            control.eliminarPerfilArtista(id);  // Método que tienes que crear en ControladoraLogica
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
            return; // para que no continue el redirect si hay error
        }
        response.sendRedirect("SvPerfilListar"); // Recarga el listado de perfiles
    }
}
