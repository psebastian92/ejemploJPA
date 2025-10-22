<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Artistas 🎵</title>
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
            box-shadow: 0 4px 20px rgba(0,0,0,0.4);
        }

        h1 {
            font-weight: bold;
            color: #ffcc00;
        }

        label {
            color: #f8f9fa;
            font-weight: 500;
        }

        .form-control {
            background-color: #e9ecef;
            border-radius: 10px;
        }

        .btn-warning {
            font-weight: bold;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(255,204,0,0.3);
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
        <h1 class="text-center mb-4">🎤 Gestión de Artistas</h1>

        <form action="${pageContext.request.contextPath}/SvArtistaCrear" method="post">
            <div class="row g-3 mb-4">
                <div class="col-md-6">
                    <label class="form-label">Nombre</label>
                    <input type="text" name="nombre" class="form-control" placeholder="Ej: Gustavo Cerati" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Género Musical</label>
                    <input type="text" name="genero" class="form-control" placeholder="Ej: Rock" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Edad</label>
                    <input type="number" name="edad" class="form-control" placeholder="Ej: 55" required>
                </div>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-warning px-5 py-2 me-2">➕ Agregar</button>
                <a href="${pageContext.request.contextPath}/SvArtistaListar" class="btn btn-outline-light px-5 py-2">📜 Ver Lista</a>
            </div>
        </form>

        <p class="text-center footer-text">Sistema de gestión musical 🎶</p>
    </div>
</div>

</body>
</html>
