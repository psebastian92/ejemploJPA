<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.logica.Artista" %>
<%@ page import="com.app.logica.Cancion" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado de Artistas 🎧</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script>
  // Mostrar/ocultar el select de canciones para un artista
  function toggleSelect(id) {
    var select = document.getElementById('selectCanciones' + id);
    if (select.style.display === 'inline-block' || select.style.display === '') {
      select.style.display = 'none';
    } else {
      select.style.display = 'inline-block';
    }
  }
</script>
</head>
<body class="bg-dark text-light">
<div class="container mt-5">
  <div class="card shadow-lg bg-secondary p-4 rounded-4">
    <h2 class="text-center text-warning mb-4">🎶 Lista de Artistas</h2>
    <table class="table table-striped table-hover table-dark rounded-3 align-middle">
      <thead class="table-warning text-dark">
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Género Musical</th>
          <th>Edad</th>
          <th>Canciones</th>
          <th class="text-center">Acciones</th>
        </tr>
      </thead>
      <tbody>
      <%
        List<Artista> listaArtistas = (List<Artista>) request.getAttribute("listaArtistas");
        if (listaArtistas != null && !listaArtistas.isEmpty()) {
          for (Artista art : listaArtistas) {
      %>
        <tr>
          <td><%= art.getId() %></td>
          <td><%= art.getNombre() %></td>
          <td><%= art.getGeneroMusical() %></td>
          <td><%= art.getEdad() %></td>
          <td>
  
            <select id="selectCanciones<%= art.getId() %>" style="display:none; margin-left:10px;" class="form-select form-select-sm d-inline-block w-auto">
              <%
                List<Cancion> canciones = art.getListaCanciones();
                if (canciones != null && !canciones.isEmpty()) {
                  for (Cancion can : canciones) {
              %>
                <option value="<%= can.getId() %>"><%= can.getTitulo() %></option>
              <%
                  }
                } else {
              %>
                <option disabled>No tiene canciones</option>
              <%
                }
              %>
            </select>
          </td>
          <td class="text-center">
            <form action="SvEditarArtista" method="get" class="d-inline">
              <input type="hidden" name="id" value="<%= art.getId() %>">
              <button type="submit" class="btn btn-outline-warning btn-sm">✏️ Editar</button>
            </form>
            <form action="SvEliminarArtista" method="post" class="d-inline">
              <input type="hidden" name="id" value="<%= art.getId() %>">
              <button type="submit" class="btn btn-outline-danger btn-sm"
                onclick="return confirm('¿Seguro que deseas eliminar a <%= art.getNombre() %>?')">❌ Eliminar</button>
            </form>
          </td>
        </tr>
      <%
          }
        } else {
      %>
        <tr>
          <td colspan="6" class="text-center">No hay artistas para mostrar</td>
        </tr>
      <%
        }
      %>
      </tbody>
    </table>
    <div class="text-center mt-4">
    <a href="<%= request.getContextPath() %>/SvPerfilListar" class="btn btn-outline-info">
        👤 Ver Perfiles
    </a>
</div>
    
    <div class="text-center mt-4">
      <a href="<%= request.getContextPath() %>/index.jsp" class="btn btn-outline-light">Volver</a>
    </div>
  </div>
</div>
</body>
</html>
