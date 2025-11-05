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

@WebServlet(name = "SvPerfilEditar", urlPatterns = { "/SvPerfilEditar" })
public class SvPerfilEditar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ControladoraLogica control = new ControladoraLogica();

    // Mostrar datos actuales en el formulario para editar
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Artista> listaArtistas = control.listarArtistas();

        int id = Integer.parseInt(request.getParameter("id"));
        PerfilArtista perfil = control.buscarPerfilArtista(id);  // Método que debes crear

        request.setAttribute("listaArtistas", listaArtistas);
        request.setAttribute("perfil", perfil);
        request.getRequestDispatcher("vistas/editarPerfil.jsp").forward(request, response);
    }

    // Actualizar datos del perfil
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String biografia = request.getParameter("biografia");
        String fotoPerfilUrl = request.getParameter("fotoPerfilUrl");
        String fotoPortadaUrl = request.getParameter("fotoPortadaUrl");
        String cantSeguidoresStr = request.getParameter("cantSeguidores");
        int idArtista = Integer.parseInt(request.getParameter("artista_id"));
        int cantSeguidores = Integer.parseInt(cantSeguidoresStr);

        PerfilArtista perfil = control.buscarPerfilArtista(id);
        Artista artista = control.buscarUnArtista(idArtista);

        perfil.setBiografia(biografia);
        perfil.setFotoPerfilUrl(fotoPerfilUrl);
        perfil.setFotoPortadaUrl(fotoPortadaUrl);
        perfil.setCantSeguidores(cantSeguidores);
        perfil.setArtista(artista);

        try {
            control.editarPerfilArtista(perfil);  // Método que debes crear en controladora lógica
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("vistas/error.jsp").forward(request, response);
            return; // para no continuar con el redirect si hay error
        }

        response.sendRedirect("SvPerfilListar");
    }
}
