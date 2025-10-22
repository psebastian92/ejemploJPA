<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error 😢</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark text-light">
<div class="container mt-5">
    <div class="alert alert-danger shadow-lg rounded-4">
        <h3 class="text-center">⚠️ Ocurrió un error</h3>
        <p class="text-center">${error}</p>
        <div class="text-center">
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-outline-light">Volver</a>
        </div>
    </div>
</div>
</body>
</html>
