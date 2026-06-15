<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.gestion.etudiants.model.Student" %>
<html>
<head>
    <title>Modifier un Étudiant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="text-warning">Modifier un Étudiant</h1>
            <a href="students" class="btn btn-outline-secondary">&larr; Retour</a>
        </div>
        <%
            Student s = (Student) request.getAttribute("student");
        %>
        <div class="card shadow">
            <div class="card-body">
                <form method="post" action="edit">
                    <input type="hidden" name="id" value="<%= s.getId() %>">
                    <div class="mb-3">
                        <label for="nom" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" value="<%= s.getNom() %>" required>
                    </div>
                    <div class="mb-3">
                        <label for="prenom" class="form-label">Prénom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom" value="<%= s.getPrenom() %>" required>
                    </div>
                    <button type="submit" class="btn btn-warning">Modifier</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
