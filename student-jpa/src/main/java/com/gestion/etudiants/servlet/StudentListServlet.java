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
import java.util.List;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
    private final StudentDAO dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Student> students = dao.findAll();
            req.setAttribute("students", students);
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
