# Library Book Tracker (v2.1)

A modern, macOS-inspired Library Management System equipped with persistent storage, admin authentication, and a premium UI.

## Project Index
- **Frontend**: `src/main/resources/static` (HTML/CSS/JS)
- **Backend**: `src/main/java` (Spring Boot 3.4.0)
- **Database**: `data/librarydb` (H2 File Storage)

## Features
- **Public Portal**: Search and Borrow books.
- **Admin Dashboard**: Secure login to Add/Manage books.
- **Persistence**: Data survives application restarts.
- **Premium UI**: Dark Glassmorphism theme with 'Poppins' typography.

## How to Run

1. **Start the Server**:
   ```bash
   mvn spring-boot:run
   ```
2. **Access Application**:
   - **Public Site**: [http://localhost:8080](http://localhost:8080)
   - **Admin Login**: [http://localhost:8080/login.html](http://localhost:8080/login.html)
     - **Password**: `admin`

## Database Access (Optional)
If you need to inspect raw data via H2 Console:
1. Go to: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. **JDBC URL**: `jdbc:h2:file:./data/librarydb`
3. **User**: `sa`
4. **Password**: `password`
