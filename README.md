# Library Book Tracker 📚

A modern, macOS-inspired **Library Management System** equipped with persistent storage, admin authentication, and a premium Glassmorphism UI.

## 🚀 Key Features
- **Public Portal**: Live Search and Borrowing functionality.
- **Admin Dashboard**: Secure login (`admin`) to **Add** or **Remove** books.
- **Persistent Database**: Data is stored efficiently in a local file (`data/`) and survives restarts.
- **Sequential IDs**: Custom database strategy ensures book IDs have no gaps (e.g., #1, #2, #3).
- **Premium UI**: Dark Glassmorphism theme with 'Poppins' typography.

## 🛠️ How to Run

### Option 1: Using Maven (Developers)
```bash
mvn spring-boot:run
```

### Option 2: Using the JAR File (Production)
Since the JAR is uploaded to the repo, you can run it directly:
```bash
java -jar target/book-tracker-0.0.1-SNAPSHOT.jar
```

## 🌐 Accessing the App (Note: Port 9090)
> We use Port **9090** to prevent conflicts.

- **Public Site**: [http://localhost:9090](http://localhost:9090)
- **Admin Login**: [http://localhost:9090/login.html](http://localhost:9090/login.html)
  - **Password**: `admin`

## 📂 Database Access (For Evaluators)
Inspect raw data via the H2 Console:
1. URL: [http://localhost:9090/h2-console](http://localhost:9090/h2-console)
2. **JDBC URL**: `jdbc:h2:file:./data/librarydb`
3. **User**: `sa`
4. **Password**: `password`
