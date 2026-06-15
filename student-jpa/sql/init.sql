CREATE DATABASE IF NOT EXISTS gestion_etudiants;
USE gestion_etudiants;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL
);

INSERT INTO students (nom, prenom) VALUES
('Benali', 'Alice'),
('Cheraka', 'Bob'),
('Zahra', 'Fatima');
