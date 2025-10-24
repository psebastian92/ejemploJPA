<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="com.app.logica.Cancion"%>
<%@ page import="com.app.logica.Artista"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Listado de Canciones 🎵</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-dark text-light">

	<div class="container mt-5">
		<div class="card shadow-lg bg-secondary p-4 rounded-4">
			<h2 class="text-center text-warning mb-4">🎶 Lista de Canciones</h2>

			<table
				class="table table-striped table-hover table-dark rounded-3 align-middle">
				<thead class="table-warning text-dark">
					<tr>
						<th>ID</th>
						<th>Título</th>
						<th>Duración</th>
						<th>Año</th>
						<th>Artista</th>
						<th class="text-center">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Cancion> listaCanciones = (List<Cancion>) request.getAttribute("listaCanciones");
					if (listaCanciones != null && !listaCanciones.isEmpty()) {
						for (Cancion cancion : listaCanciones) {
					%>
					<tr>
						<td><%=cancion.getId()%></td>
						<td><%=cancion.getTitulo()%></td>
						<td><%=cancion.getDuracion()%> min</td>
						<td><%=cancion.getAnio()%></td>
						<td>
							<%
							Artista artista = cancion.getArtista();
							if (artista != null) {
								out.print(artista.getNombre());
							} else {
								out.print("<span class='text-muted'>Sin artista</span>");
							}
							%>
						</td>
						<td class="text-center">
							<!-- Botón editar -->
							<form action="SvCancionEditar" method="get" class="d-inline">
								<input type="hidden" name="id" value="<%=cancion.getId()%>">
								<button type="submit" class="btn btn-outline-warning btn-sm">✏️
									Editar</button>
							</form> <!-- Botón eliminar -->
							<form action="SvCancionEliminar" method="post" class="d-inline">
								<input type="hidden" name="id" value="<%=cancion.getId()%>">
								<button type="submit" class="btn btn-outline-danger btn-sm"
									onclick="return confirm('¿Seguro que deseas eliminar la canción <%=cancion.getTitulo()%>?')">
									❌ Eliminar</button>
							</form>
						</td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="6" class="text-center text-muted">No hay
							canciones registradas.</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<div class="text-center mt-4">
				<a href="<%=request.getContextPath()%>/index.jsp"
					class="btn btn-outline-light me-2">🏠 Volver al inicio</a> <a
					href="<%=request.getContextPath()%>/SvCancionCrear"
					class="btn btn-warning">➕ Agregar Canción</a> 
			</div>

		</div>
	</div>

</body>
</html>
