<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.app.logica.Artista"%>
<%@ page import="com.app.logica.PerfilArtista"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Perfiles de Artistas 🎤</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark text-light">
<div class="container mt-5">
    <div class="card shadow-lg bg-secondary p-4 rounded-4">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2 class="text-warning">🎶 Perfiles de Artistas</h2>
            <a href="<%=request.getContextPath()%>/SvPerfilCrear" 
               class="btn btn-success btn-lg shadow-sm">
               <i class="bi bi-person-plus-fill"></i> Agregar Perfil
            </a>
        </div>

        <table class="table table-striped table-hover table-dark rounded-3 align-middle">
            <thead class="table-warning text-dark">
                <tr>
                    <th>ID</th>
                    <th>Biografía</th>
                    <th>Foto Perfil</th>
                    <th>Foto Portada</th>
                    <th>Seguidores</th>
                    <th>Nombre Artista</th>
                    <th>Género Musical</th>
                    <th>Edad</th>
                    <th class="text-center">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<PerfilArtista> listaPerfiles = (List<PerfilArtista>) request.getAttribute("listaPerfiles");
                if (listaPerfiles != null && !listaPerfiles.isEmpty()) {
                    for (PerfilArtista perf : listaPerfiles) {
                        Artista art = perf.getArtista();
                %>
                <tr>
                    <td><%= perf.getId() %></td>
                    <td><%= perf.getBiografia() %></td>
                    <td>
                        <% if (perf.getFotoPerfilUrl() != null && !perf.getFotoPerfilUrl().isEmpty()) { %>
                            <img src="<%= perf.getFotoPerfilUrl() %>" alt="Foto Perfil" width="50">
                        <% } else { %>
                            N/A
                        <% } %>
                    </td>
                    <td>
                        <% if (perf.getFotoPortadaUrl() != null && !perf.getFotoPortadaUrl().isEmpty()) { %>
                            <img src="<%= perf.getFotoPortadaUrl() %>" alt="Foto Portada" width="50">
                        <% } else { %>
                            N/A
                        <% } %>
                    </td>
                    <td><%= perf.getCantSeguidores() %></td>
                    <td><%= art != null ? art.getNombre() : "N/A" %></td>
                    <td><%= art != null ? art.getGeneroMusical() : "N/A" %></td>
                    <td><%= art != null ? art.getEdad() : "N/A" %></td>
                    <td class="text-center">
                        <form action="SvPerfilEditar" method="get" class="d-inline">
                            <input type="hidden" name="id" value="<%= perf.getId() %>">
                            <button type="submit" class="btn btn-outline-warning btn-sm">✏️ Editar</button>
                        </form>
                        <form action="SvPerfilEliminar" method="post" class="d-inline">
                            <input type="hidden" name="id" value="<%= perf.getId() %>">
                            <button type="submit" class="btn btn-outline-danger btn-sm"
                                    onclick="return confirm('¿Seguro que deseas eliminar el perfil de <%= art != null ? art.getNombre() : "" %>?')">
                                ❌ Eliminar
                            </button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="9" class="text-center">No hay perfiles para mostrar</td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>

        <div class="text-center mt-4">
            <a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-outline-light">Volver</a>
        </div>
    </div>
</div>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</body>
</html>
