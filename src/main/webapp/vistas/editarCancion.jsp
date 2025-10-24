<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.logica.Artista" %>
<%@ page import="com.app.logica.Cancion" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Editar Canción ✏️</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark text-light">
  <div class="container mt-5">
    <div class="card bg-secondary shadow-lg p-4 rounded-4">
      <h2 class="text-center text-warning mb-4">Editar Canción</h2>

      <form action="${pageContext.request.contextPath}/SvCancionEditar" method="post">
        <input type="hidden" name="id" value="${cancion.id}">

        <div class="mb-3">
          <label class="form-label">Título</label>
          <input type="text" name="titulo" class="form-control" value="${cancion.titulo}" required>
        </div>

        <div class="mb-3">
          <label class="form-label">Duración (minutos)</label>
          <input type="number" step="0.01" name="duracion" class="form-control" value="${cancion.duracion}" required>
        </div>

        <div class="mb-3">
          <label class="form-label">Año</label>
          <input type="number" name="anio" class="form-control" value="${cancion.anio}" required>
        </div>

        <div class="mb-3">
          <label class="form-label">Artista Asociado</label>
          
          <!-- CAMBIAR ARTISTA ASOCIADO --> 
          <select name="artistaId" class="form-select" required>
            <option value="">-- Seleccione un artista --</option>
            <%
              List<Artista> listaArtistas = (List<Artista>) request.getAttribute("listaArtistas");
              Cancion cancion = (Cancion) request.getAttribute("cancion");
              if (listaArtistas != null) {
                for (Artista art : listaArtistas) {
                  boolean seleccionado = (cancion.getArtista() != null && art.getId() == cancion.getArtista().getId());
            %>
              <option value="<%= art.getId() %>" <%= seleccionado ? "selected" : "" %> >
                <%= art.getNombre() %>
              </option>
            <%
                }
              }
            %>
          </select>
        </div>

        <div class="text-center mt-4">
          <button type="submit" class="btn btn-warning fw-bold">Guardar Cambios</button>
          <a href="${pageContext.request.contextPath}/SvCancionListar" class="btn btn-outline-light ms-2">Cancelar</a>
        </div>
      </form>

    </div>
  </div>
</body>
</html>
