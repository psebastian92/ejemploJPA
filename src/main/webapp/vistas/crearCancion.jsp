<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.logica.Artista" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Canción 🎵</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #1f1f1f, #2e2e2e);
            color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
        }

        .card {
            background-color: #3a3f44;
            border: none;
            border-radius: 20px;
            padding: 2rem;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.4);
        }

        h1 {
            font-weight: bold;
            color: #ffcc00;
        }

        label {
            color: #f8f9fa;
            font-weight: 500;
        }

        .form-control, select {
            background-color: #e9ecef;
            border-radius: 10px;
        }

        .btn-warning {
            font-weight: bold;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(255, 204, 0, 0.3);
        }

        .btn-outline-light:hover {
            background-color: #ffcc00;
            color: #212529;
        }

        .footer-text {
            color: #aaa;
            font-size: 0.9rem;
            margin-top: 1rem;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="card mx-auto" style="max-width: 800px;">
        <h1 class="text-center mb-4">🎶 Agregar Canción</h1>

        <form action="${pageContext.request.contextPath}/SvCancionCrear" method="post">
            <div class="row g-3 mb-4">
                <div class="col-md-6">
                    <label class="form-label">Título</label>
                    <input type="text" name="titulo" class="form-control" placeholder="Ej: Persiana Americana" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Duración (min)</label>
                    <input type="number" step="0.01" name="duracion" class="form-control" placeholder="Ej: 4.22" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Año de lanzamiento</label>
                    <input type="number" name="anio" class="form-control" placeholder="Ej: 1986" required>
                </div>

                <div class="col-md-6">
                    <label class="form-label">Artista</label>
                    <select name="artista_id" class="form-select" required>
                        <option value="">Seleccione un artista</option>
                        <%
                            List<Artista> listaArtistas = (List<Artista>) request.getAttribute("listaArtistas");
                            if (listaArtistas != null) {
                                for (Artista art : listaArtistas) {
                        %>
                                    <option value="<%= art.getId() %>"><%= art.getNombre() %></option>
                        <%
                                }
                            } else {
                        %>
                                    <option disabled>No hay artistas disponibles</option>
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-warning px-5 py-2 me-2">➕ Agregar</button>
                <a href="${pageContext.request.contextPath}/SvCancionListar" class="btn btn-outline-light px-5 py-2">📜 Ver Canciones</a>
                <a
					href="<%=request.getContextPath()%>/index.jsp"
					class="btn btn-outline-light">Volver</a>
            </div>
        </form>

        <p class="text-center footer-text">Sistema de gestión musical 🎶</p>
    </div>
</div>

</body>
</html>
