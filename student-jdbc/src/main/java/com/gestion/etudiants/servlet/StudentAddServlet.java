package com.gestion.etudiants.servlet;

import com.gestion.etudiants.dao.StudentDAO;
import com.gestion.etudiants.dao.StudentDAOImpl;
import com.gestion.etudiants.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajouter")
public class StudentAddServlet extends HttpServlet {
    private final StudentDAO dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ajouter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");

        if (nom == null || prenom == null || nom.trim().isEmpty() || prenom.trim().isEmpty()) {
            req.setAttribute("error", "Tous les champs sont obligatoires");
            req.getRequestDispatcher("ajouter.jsp").forward(req, resp);
            return;
        }

        try {
            dao.save(new Student(nom.trim(), prenom.trim()));
            resp.sendRedirect("students");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Erreur lors de l'ajout");
            req.getRequestDispatcher("ajouter.jsp").forward(req, resp);
        }
    }
}
