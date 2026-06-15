package com.gestion.etudiants.dao;

import com.gestion.etudiants.model.Student;
import jakarta.persistence.*;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public Student findById(int id) {
        EntityManager em = JpaPersistence.getEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Student> findAll() {
        EntityManager em = JpaPersistence.getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Student s ORDER BY s.id", Student.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void save(Student student) {
        EntityManager em = JpaPersistence.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Student student) {
        EntityManager em = JpaPersistence.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager em = JpaPersistence.getEntityManager();
        try {
            em.getTransaction().begin();
            Student s = em.find(Student.class, id);
            if (s != null) {
                em.remove(s);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
