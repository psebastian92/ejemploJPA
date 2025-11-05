<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.logica.Artista" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Crear Perfil de Artista 👤</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">
<style>
    h2 {
        text-shadow: 2px 2px 4px #000; /* sombra ligera para resaltar */
    }
</style>
</head>
<body class="bg-dark text-light">
<div class="container mt-5">
  <div class="card shadow-lg bg-secondary p-5 rounded-4">
    <h2 class="text-center text-success fw-bold mb-5">➕ Crear Nuevo Perfil</h2>

    <form action="<%= request.getContextPath() %>/SvPerfilCrear" method="post">
      
      <div class="mb-4">
        <label for="artista_id" class="form-label">Seleccionar Artista</label>
        <select class="form-select" id="artista_id" name="artista_id" required>
          <option value="" disabled selected>-- Selecciona un artista --</option>
          <%
            List<Artista> listaArtistas = (List<Artista>) request.getAttribute("listaArtistas");
            if (listaArtistas != null) {
                for (Artista art : listaArtistas) {
          %>
            <option value="<%= art.getId() %>"><%= art.getNombre() %></option>
          <%
                }
            }
          %>
        </select>
      </div>

      <div class="mb-4">
        <label for="biografia" class="form-label">Biografía</label>
        <textarea class="form-control" id="biografia" name="biografia" rows="3" required></textarea>
      </div>

      <div class="mb-4">
        <label for="fotoPerfilUrl" class="form-label">URL Foto de Perfil</label>
        <input type="text" class="form-control" id="fotoPerfilUrl" name="fotoPerfilUrl" required>
      </div>

      <div class="mb-4">
        <label for="fotoPortadaUrl" class="form-label">URL Foto de Portada</label>
        <input type="text" class="form-control" id="fotoPortadaUrl" name="fotoPortadaUrl" required>
      </div>

      <div class="mb-4">
        <label for="cantSeguidores" class="form-label">Cantidad de Seguidores</label>
        <input type="number" class="form-control" id="cantSeguidores" name="cantSeguidores" min="0" required>
      </div>

      <div class="text-center mt-4">
        <button type="submit" class="btn btn-success btn-lg shadow-sm">
            <i class="bi bi-save2-fill"></i> Guardar Perfil
        </button>
        <a href="<%= request.getContextPath() %>/SvPerfilCrear" class="btn btn-outline-light btn-lg ms-3">
            <i class="bi bi-x-circle-fill"></i> Cancelar
        </a>
      </div>
    </form>
  </div>
</div>
</body>
</html>
