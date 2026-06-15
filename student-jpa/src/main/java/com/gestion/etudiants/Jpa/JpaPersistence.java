package com.gestion.etudiants.dao;

import jakarta.persistence.*;

public class JpaPersistence {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("StudentPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}
