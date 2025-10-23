<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión Musical 🎵</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #1f1f1f, #2e2e2e);
            color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .card {
            background-color: #3a3f44;
            border: none;
            border-radius: 20px;
            padding: 3rem;
            box-shadow: 0 4px 25px rgba(0,0,0,0.4);
            text-align: center;
            width: 500px;
        }

        h1 {
            font-weight: bold;
            color: #ffcc00;
            margin-bottom: 1.5rem;
        }

        p {
            color: #f8f9fa;
            font-size: 1rem;
            line-height: 1.5;
        }

        .btn-custom {
            font-weight: bold;
            border-radius: 12px;
            padding: 1rem 2rem;
            font-size: 1.1rem;
            transition: all 0.3s ease;
            box-shadow: 0 4px 8px rgba(255,204,0,0.3);
            margin-bottom: 1rem;
        }

        .btn-custom:hover {
            transform: translateY(-3px);
        }

        .btn-warning {
            background-color: #ffcc00;
            border: none;
            color: #212529;
        }

        .btn-outline-light {
            border: 2px solid #f8f9fa;
            color: #f8f9fa;
        }

        .btn-outline-light:hover {
            background-color: #ffcc00;
            color: #212529;
            border-color: #ffcc00;
        }

        .footer-text {
            color: #aaa;
            font-size: 0.9rem;
            margin-top: 1.5rem;
        }
    </style>
</head>
<body>

<div class="card">
    <h1>🎶 Gestión Musical</h1>

    <p class="mt-3">
        Bienvenido al <strong>Sistema de Gestión Musical</strong> 🎵<br>
        Esta aplicación te permite administrar <strong>artistas</strong> y <strong>canciones</strong> 
        utilizando tecnologías <strong>Java Servlet, JSP y JPA</strong>.  
        Podrás crear, editar, eliminar y listar registros, con persistencia real en base de datos.  
        <br><br>Elegí una opción para comenzar:
    </p>

    <div class="d-grid gap-3 mt-4">
        <a href="${pageContext.request.contextPath}/SvArtistaListar" class="btn btn-outline-light btn-custom">📜 Ver Artistas</a>
        <a href="${pageContext.request.contextPath}/vistas/crearArtista.jsp" class="btn btn-warning btn-custom">➕ Agregar Artista</a>
        <a href="${pageContext.request.contextPath}/SvCancionCrear" class="btn btn-warning btn-custom">🎵 Agregar Canción</a>
    </div>

    <p class="footer-text mt-4">Proyecto académico — JSP + Servlets + JPA</p>
</div>

</body>
</html>
