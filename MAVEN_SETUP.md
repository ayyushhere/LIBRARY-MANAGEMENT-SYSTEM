# Maven Installation Guide for Windows

This project uses Apache Maven for build and dependency management.

## 1. Using Maven Wrapper (Recommended)
This project includes a Maven Wrapper, which allows you to run Maven commands without having Maven installed globally.
- Use `mvnw` (or `mvnw.cmd` on Windows) instead of `mvn`.
- Example: `.\mvnw clean install`

## 2. Installing Maven System-Wide

### Option A: Using Chocolatey (Easiest)
If you have [Chocolatey](https://chocolatey.org/) installed, run:
```powershell
choco install maven
```

### Option B: Manual Installation
1. Download the binary zip archive from [Apache Maven Download](https://maven.apache.org/download.cgi).
2. Unzip it to a directory of your choice (e.g., `C:\Progra~1\Maven`).
3. Add the `bin` directory to your System `PATH` environment variable.
   - Search for "Environment Variables" in Windows Search.
   - Edit "Path" variable and add the path (e.g., `C:\Progra~1\Maven\apache-maven-3.9.6\bin`).

## 3. Verify Installation
Open a new terminal and run:
```bash
mvn -version
```
You should see output similar to:
```
Apache Maven 3.9.x ...
Maven home: ...
Java version: ...
```
