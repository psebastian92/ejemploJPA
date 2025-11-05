package com.app.servletsPerfil;

import java.io.IOException;
import java.util.List;

import com.app.logica.Artista;
import com.app.logica.ControladoraLogica;
import com.app.logica.PerfilArtista;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvPerfilCrear", urlPatterns = {"/SvPerfilCrear"})
public class SvPerfilCrear extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    ControladoraLogica control = new ControladoraLogica();

    // Mostrar lista de artistas para seleccionar al crear perfil
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Artista> listaArtistas = control.listarArtistas();
        request.setAttribute("listaArtistas", listaArtistas);
        request.getRequestDispatcher("vistas/crearPerfil.jsp").forward(request, response);
    }

    // Crear un nuevo perfil artista
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String biografia = request.getParameter("biografia");
        String fotoPerfilUrl = request.getParameter("fotoPerfilUrl");
        String fotoPortadaUrl = request.getParameter("fotoPortadaUrl");
        String cantSeguidoresStr = request.getParameter("cantSeguidores");
        int idArtista = Integer.parseInt(request.getParameter("artista_id"));
        
        int cantSeguidores = Integer.parseInt(cantSeguidoresStr);

        Artista artista = control.buscarUnArtista(idArtista);
        PerfilArtista nuevoPerfil = new PerfilArtista();

        nuevoPerfil.setBiografia(biografia);
        nuevoPerfil.setFotoPerfilUrl(fotoPerfilUrl);
        nuevoPerfil.setFotoPortadaUrl(fotoPortadaUrl);
        nuevoPerfil.setCantSeguidores(cantSeguidores);
        nuevoPerfil.setArtista(artista);

        try {
            control.crearPerfilArtista(nuevoPerfil);  // Este método debe existir en ControladoraLogica
            response.sendRedirect("SvPerfilListar");  // Redirige al listado de perfiles
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
        }
    }
}
