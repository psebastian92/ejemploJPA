<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Editar Artista ✏️</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-dark text-light">
	<div class="container mt-5">
		<div class="card bg-secondary shadow-lg p-4 rounded-4">
			<h2 class="text-center text-warning mb-4">Editar Artista</h2>

			<form action="${pageContext.request.contextPath}/SvEditarArtista"
				method="post">
				<input type="hidden" name="id" value="${art.id}">

				<div class="mb-3">
					<label class="form-label">Nombre</label> <input type="text"
						name="nombre" class="form-control" value="${art.nombre}" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Género Musical</label> <input type="text"
						name="genero" class="form-control" value="${art.generoMusical}"
						required>
				</div>

				<div class="mb-3">
					<label class="form-label">Edad</label> <input type="number"
						name="edad" class="form-control" value="${art.edad}" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Nacionalidad</label> <input type="text"
						name="nacionalidad" class="form-control"
						value="${art.nacionalidad}" required>
				</div>
				<div class="text-center mt-4">
					<button type="submit" class="btn btn-warning fw-bold">Guardar
						Cambios</button>
					<a href="${pageContext.request.contextPath}/SvArtistaListar"
						class="btn btn-outline-light ms-2">Cancelar</a>>
				</div>

			</form>

		</div>
	</div>
</body>
</html>
