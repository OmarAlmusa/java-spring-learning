# Project Setup and Database Management

This project utilizes **PostgreSQL** as its primary database, managed through **Docker** for easy setup and consistency across development environments.  
**Liquibase** handles database migrations, ensuring version control and smooth schema evolution.  
**DBeaver** is recommended as a powerful graphical tool for database exploration and management.

---

## 🐳 Database Setup (PostgreSQL with Docker)

The PostgreSQL database runs within a Docker container, providing an isolated and reproducible environment.

### Prerequisites
- Docker installed and running on your system

### To Start the PostgreSQL Container

1. **Pull the PostgreSQL image** (if you haven't already):

   ```bash
   docker pull postgres:latest
   ```

2. **Run the PostgreSQL container**:

   ```bash
   docker run --name my-postgres      -e POSTGRES_PASSWORD=mysecretpassword      -p 5432:5432      -d postgres
   ```

   - `--name my-postgres`: Assigns a name to your container (you can choose any name).
   - `-e POSTGRES_PASSWORD=mysecretpassword`: Sets the password for the `postgres` user. Make sure this matches the `spring.datasource.password` in your `application.properties`.
   - `-p 5432:5432`: Maps port 5432 on your host to the container.
   - `-d postgres`: Runs the container in detached mode using the `postgres` image.

3. **Verify the container is running**:

   ```bash
   docker ps
   ```

   You should see `my-postgres` listed.

Your Spring Boot application will connect to this database using the connection details from `application.properties`.

---

## 🧰 Database Viewer (DBeaver)

**DBeaver** is a universal database tool that lets you manage your PostgreSQL database, execute SQL queries, and inspect data.

### Setup with DBeaver

1. Download and install **DBeaver Community Edition**.
2. Create a new connection:
   - Open DBeaver.
   - Click **"New Database Connection"** (plug icon or `Ctrl+Alt+C`).
   - Select **PostgreSQL** from the list and click **Next**.
3. Fill in the connection details:
   - **Host**: `localhost`
   - **Port**: `5432`
   - **Database**: `postgres` (or your specific DB name)
   - **Username**: `postgres`
   - **Password**: `mysecretpassword` (or whatever you set)
4. Click **"Test Connection..."** to verify setup.
5. Click **"Finish"**.

You're now ready to browse schemas, view data, and run queries.

---

## 🔁 Database Migrations (Liquibase Integration)

This project uses **Liquibase** for managing database schema changes. Liquibase tracks changes in version-controlled changelog files (YAML) and applies them incrementally.

### Key Concepts

- **`db.changelog-master.yaml`**: Main changelog file that includes other specific changelogs. Entry point for Liquibase.
- **`db.changelog-1.0.yaml`, `1.1.yaml`, ...**: Individual changelog files containing sets of DB changes (creating tables, columns, constraints, etc.).
- Each `changeSet` has a unique `id` and `author`.

### How Liquibase Works

#### Configuration (`application.properties`)

```properties
spring.jpa.hibernate.ddl-auto=none   # Disable Hibernate schema generation
spring.liquibase.enabled=true
spring.liquibase.change-log=classpath:/db/changelog/db.changelog-master.yaml
```

#### Automatic Execution

On application startup:
- Liquibase scans and applies pending changelogs.
- Tracks execution in an internal `databasechangelog` table.

#### Schema Evolution

For future changes:
1. Create a new changelog file (e.g., `db.changelog-1.1.yaml`).
2. Include it in `db.changelog-master.yaml`.
3. Liquibase will apply only the new changes.

---

### ⚠️ Important Note for Initial Setup

If your database already contains tables that Liquibase is configured to create (e.g., `student`, `school`, `student_profile`), you might encounter `table already exists` errors.

**To avoid this**:
- **Start with a clean database**: Drop existing tables manually or recreate the Docker container.

---

This setup provides a robust, version-controlled approach to managing your database schema.