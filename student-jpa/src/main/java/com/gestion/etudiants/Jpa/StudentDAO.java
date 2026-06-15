package com.gestion.etudiants.dao;

import com.gestion.etudiants.model.Student;
import java.util.List;

public interface StudentDAO {
    Student findById(int id);
    List<Student> findAll();
    void save(Student student);
    void update(Student student);
    void delete(int id);
}
