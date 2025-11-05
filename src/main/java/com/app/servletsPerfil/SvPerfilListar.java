package com.app.servletsPerfil;

import java.io.IOException;
import java.util.List;

import com.app.logica.ControladoraLogica;
import com.app.logica.PerfilArtista;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvPerfilListar", urlPatterns = {"/SvPerfilListar"})
public class SvPerfilListar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<PerfilArtista> listaPerfiles = control.listarPerfilesArtistas();  // Debes crear este método
        request.setAttribute("listaPerfiles", listaPerfiles);

        // Recuperar mensajes de sesión
        String mensaje = (String) request.getSession().getAttribute("mensaje");
        String error = (String) request.getSession().getAttribute("error");

        if (mensaje != null) {
            request.setAttribute("mensaje", mensaje);
            request.getSession().removeAttribute("mensaje");
        }
        if (error != null) {
            request.setAttribute("error", error);
            request.getSession().removeAttribute("error");
        }

        request.getRequestDispatcher("vistas/listaPerfiles.jsp").forward(request, response);
    }
}
