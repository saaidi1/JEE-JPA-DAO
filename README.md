# Gestion des Étudiants — JPA / JDBC

Projet JEE de gestion des étudiants avec deux implémentations DAO :

| Projet | Technologie DB | DAO |
|--------|---------------|-----|
| `student-jpa` | JPA / Hibernate | `StudentDAO` dans le package `Jpa` |
| `student-jdbc` | JDBC pur | `StudentDAO` dans le package `dao` |

## Structure

```
student-jpa/       ← JPA + Hibernate + EntityManager
├── src/main/java/com/gestion/etudiants/
│   ├── Jpa/       ← StudentDAO, StudentDAOImpl, JpaPersistence (EMF)
│   ├── model/     ← Student (entité JPA)
│   └── servlet/   ← StudentListServlet, StudentAddServlet, ...
├── src/main/resources/META-INF/persistence.xml
├── src/main/webapp/ ← JSP (list, ajouter, edit)
├── Dockerfile
├── docker-compose.yml
└── pom.xml

student-jdbc/      ← JDBC + DriverManager
├── src/main/java/com/gestion/etudiants/
│   ├── dao/       ← StudentDAO, StudentDAOImpl, DbConnection
│   ├── model/     ← Student (POJO)
│   └── servlet/   ← StudentListServlet, StudentAddServlet, ...
├── src/main/webapp/ ← JSP (list, ajouter, edit)
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

## Prérequis

- Java 17+
- Maven 3.8+
- Docker (optionnel)
- MySQL 8.0

## Commandes

### 1 — Build avec Maven

```bash
# student-jpa
cd student-jpa
mvn clean package -DskipTests

# student-jdbc
cd student-jdbc
mvn clean package -DskipTests
```

Le WAR est généré dans `target/student-management.war`.

### 2 — Lancer avec Docker

```bash
# student-jpa
cd student-jpa
docker compose up --build

# student-jdbc
cd student-jdbc
docker compose up --build
```

- MySQL expose le port **3306** (nom d'hôte Docker : `mysql`)
- Tomcat expose le port **8080**
- La base `gestion_etudiants` et la table `students` sont créées automatiquement via `sql/init.sql`

### 3 — Accès

Ouvrir dans le navigateur :  
[http://localhost:8080](http://localhost:8080)

Données de test insérées : Benali Alice, Cheraka Bob, Zahra Fatima.

### 4 — Push vers GitHub

```bash
git init
git remote add origin https://github.com/saaidi1/JEE-JPA-DAO.git
git add -A
git commit -m "Add student-jpa and student-jdbc projects"
git push -u origin main
```

## Base de données

| Paramètre | Valeur |
|-----------|--------|
| Host | `localhost` (local) / `mysql` (Docker) |
| Port | 3306 |
| Base | `gestion_etudiants` |
| User | `root` |
| Password | `root123` |

> `student-jdbc` utilise une variable d'environnement `DB_HOST` (défaut `localhost`).
> En Docker, le `docker-compose.yml` passe `DB_HOST=mysql` automatiquement.
