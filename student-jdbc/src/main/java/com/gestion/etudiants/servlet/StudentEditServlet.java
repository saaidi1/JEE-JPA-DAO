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

@WebServlet("/edit")
public class StudentEditServlet extends HttpServlet {
    private final StudentDAO dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null) {
            resp.sendRedirect("students");
            return;
        }

        try {
            Student student = dao.findById(Integer.parseInt(id));
            if (student == null) {
                resp.sendRedirect("students");
                return;
            }
            req.setAttribute("student", student);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("students");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");

        try {
            dao.update(new Student(id, nom, prenom));
            resp.sendRedirect("students");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("edit?id=" + id);
        }
    }
}
