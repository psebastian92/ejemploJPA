package com.app.servletsArtista;

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

@WebServlet(name = "SvArtistaListar", urlPatterns = {"/SvArtistaListar"})
public class SvArtistaListar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	List<Artista> listaArtistas = control.listarArtistas();

    	// Si el fetch es LAZY, forzamos la carga de canciones
    	for (Artista art : listaArtistas) {
    	    art.getListaCanciones().size(); // solo para inicializar
    	}

    	request.setAttribute("listaArtistas", listaArtistas);
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

        request.getRequestDispatcher("vistas/listaArtistas.jsp").forward(request, response);
    }
}
