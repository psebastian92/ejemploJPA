<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Artistas 🎧</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
                    <th class="text-center">Acciones</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="art" items="${listaArtistas}">
                <tr>
                    <td>${art.id}</td>
                    <td>${art.nombre}</td>
                    <td>${art.generoMusical}</td>
                    <td>${art.edad}</td>
                    <td class="text-center">
                        <!-- Botón editar -->
                        <form action="SvEditarArtista" method="get" class="d-inline">
                            <input type="hidden" name="id" value="${art.id}">
                            <button type="submit" class="btn btn-outline-warning btn-sm">✏️ Editar</button>
                        </form>

                        <!-- Botón eliminar -->
                        <form action="SvEliminarArtista" method="post" class="d-inline">
                            <input type="hidden" name="id" value="${art.id}">
                            <button type="submit" class="btn btn-outline-danger btn-sm"
                                    onclick="return confirm('¿Seguro que deseas eliminar a ${art.nombre}?')">
                                ❌ Eliminar
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="text-center mt-4">
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-outline-light">Volver</a>
        </div>
    </div>
</div>
</body>
</html>
