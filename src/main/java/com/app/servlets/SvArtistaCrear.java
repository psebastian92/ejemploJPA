package com.app.servlets;

import java.io.IOException;
import java.util.List;

import com.app.logica.Artista;
import com.app.logica.ControladoraLogica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvArtistaCrear", urlPatterns = {"/SvArtistaCrear"})
public class SvArtistaCrear extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    ControladoraLogica control = new ControladoraLogica();

    // 🔹 Mostrar lista de artistas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Artista> listaArtistas = control.listarArtistas();
        request.setAttribute("listaArtistas", listaArtistas);
        request.getRequestDispatcher("vistas/listaArtistas.jsp").forward(request, response);
    }

    // 🔹 Crear un nuevo artista
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String genero = request.getParameter("genero");
        String nacionalidad = request.getParameter("nacionalidad");
        int edad = Integer.parseInt(request.getParameter("edad"));

        Artista art = new Artista();
        art.setNombre(nombre);
        art.setGeneroMusical(genero);
        art.setNacionalidad(nacionalidad);
        art.setEdad(edad);

        try {
            control.crearArtista(art);
            response.sendRedirect("SvArtista"); // redirige al listado
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
        }
    }
}
