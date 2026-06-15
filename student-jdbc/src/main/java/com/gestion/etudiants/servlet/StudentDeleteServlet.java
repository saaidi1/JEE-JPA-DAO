package com.gestion.etudiants.servlet;

import com.gestion.etudiants.dao.StudentDAO;
import com.gestion.etudiants.dao.StudentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class StudentDeleteServlet extends HttpServlet {
    private final StudentDAO dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null) {
            resp.sendRedirect("students");
            return;
        }

        try {
            dao.delete(Integer.parseInt(id));
            resp.sendRedirect("students");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("students");
        }
    }
}
