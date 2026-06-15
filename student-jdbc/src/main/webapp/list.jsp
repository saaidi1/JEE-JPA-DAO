<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.gestion.etudiants.model.Student" %>
<html>
<head>
    <title>Liste des Étudiants</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="text-primary">Liste des Étudiants</h1>
            <div>
                <a href="ajouter" class="btn btn-success">+ Ajouter</a>
                <a href="index.jsp" class="btn btn-outline-secondary">Accueil</a>
            </div>
        </div>
        <div class="card shadow">
            <div class="card-body p-0">
                <table class="table table-striped table-hover mb-0">
                    <thead class="table-primary">
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Student> students = (List<Student>) request.getAttribute("students");
                            if (students != null && !students.isEmpty()) {
                                for (Student s : students) {
                        %>
                        <tr>
                            <td><%= s.getId() %></td>
                            <td><%= s.getNom() %></td>
                            <td><%= s.getPrenom() %></td>
                            <td>
                                <a href="edit?id=<%= s.getId() %>" class="btn btn-warning btn-sm">Modifier</a>
                                <a href="delete?id=<%= s.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Supprimer <%= s.getNom() %> ?')">Supprimer</a>
                            </td>
                        </tr>
                        <%
                                }
                            } else {
                        %>
                        <tr>
                            <td colspan="4" class="text-center text-muted py-4">Aucun étudiant trouvé</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
