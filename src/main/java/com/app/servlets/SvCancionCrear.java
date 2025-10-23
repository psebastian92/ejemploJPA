package com.app.servlets;

import java.io.IOException;
import java.util.List;

import com.app.logica.Artista;
import com.app.logica.Cancion;
import com.app.logica.ControladoraLogica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCancionCrear", urlPatterns = {"/SvCancionCrear"})
public class SvCancionCrear extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    ControladoraLogica control = new ControladoraLogica();

    // 🔹 Mostrar lista de canciones
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Artista> listaArtistas = control.listarArtistas();
        request.setAttribute("listaArtistas", listaArtistas);
        request.getRequestDispatcher("vistas/crearCancion.jsp").forward(request, response);
    }

    // 🔹 Crear una nueva cancion
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        float duracion = Float.parseFloat(request.getParameter("duracion")); 
        int anio = Integer.parseInt(request.getParameter("anio"));
        int idArtista = Integer.parseInt(request.getParameter("artista_id"));
        
        Artista artista = control.buscarUnArtista(idArtista);
        Cancion nuevaCancion = new Cancion(titulo, duracion, anio);
        nuevaCancion.setArtista(artista);

        try {
            control.crearCancion(nuevaCancion);
            response.sendRedirect("SvCancionListar"); // redirige al listado
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
        }
    }
}
