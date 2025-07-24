Sure! Here's a complete `README.md` file that **includes everything** from project overview, structure, how to run, dependencies, and `runfx.sh` content — all in one ready-to-use markdown file for your GitHub repo:

---

````markdown
# 🎯 JavaFX Login & SignUp GUI App with SQLite

A polished **JavaFX desktop application** featuring **user authentication** with local **SQLite database** integration. Includes a responsive and modern UI for login and signup forms, with proper validation and local user data persistence.

---

## ✨ Features

- 🔐 Secure Login & Signup with form validation
- 🎨 Modern JavaFX-based GUI with custom styles & layout
- 🗃️ SQLite backend using JDBC for data persistence
- 📅 DatePicker support for date of birth input
- 👋 Personalized welcome screen after login
- 💡 Easily extendable and modular codebase

---

## 📁 Project Structure

```plaintext
├── DatabaseHelper.java      # SQLite database handler (create, insert, validate)
├── HelloFX.java             # JavaFX test with emoji-style button
├── hello.java               # Console message (basic hello world)
├── LoginPage.java           # Main login screen
├── SignUpPage.java          # GUI for user registration
├── Welcome.java             # Welcome screen after login
├── runfx.sh                 # Bash script to compile and launch the app
````

---

## ⚙️ Requirements

* **Java 11 or higher**
* **JavaFX SDK** (Download: [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/))
* **SQLite JDBC Driver** (Add `sqlite-jdbc-<version>.jar` to classpath)

---

## 🏃 How to Run

### 🔧 Step 1: Setup JavaFX

Download JavaFX SDK and extract it. Set your environment variable (or update the path in `runfx.sh`):

```bash
export PATH_TO_FX=/path/to/javafx-sdk-XX/lib
```

### 📜 Step 2: Make Shell Script Executable

```bash
chmod +x runfx.sh
```

### 🚀 Step 3: Run the App

```bash
./runfx.sh
```

This will:

* Compile all `.java` files
* Run the `LoginPage` JavaFX GUI

---

## 🔁 Application Flow

1. Launch the app via `LoginPage`
2. Click on **SIGN UP** to register a new user
3. Enter username, full name, DOB, and password
4. After registration, return to login and sign in
5. On successful login, a **personalized welcome screen** is shown

---

## 🗃️ Database Schema

A local SQLite database file `users.db` is automatically created with this schema:

| Column   | Type | Description               |
| -------- | ---- | ------------------------- |
| username | TEXT | Primary key               |
| fullname | TEXT | User’s full name          |
| dob      | TEXT | Date of birth (as string) |
| password | TEXT | Password (plain text)     |

> ⚠️ **Note:** This is for demonstration only. For real-world apps, store **hashed passwords** and use **encryption**.

---

## 🧪 Test Demo: HelloFX.java

Run a basic JavaFX app to test setup:

```bash
javac --module-path $PATH_TO_FX --add-modules javafx.controls HelloFX.java
java --module-path $PATH_TO_FX --add-modules javafx.controls HelloFX
```

---

## 📜 runfx.sh (included)

```bash
#!/bin/bash

# Update with your actual path to JavaFX SDK lib
PATH_TO_FX=/path/to/javafx-sdk-XX/lib
SQLITE_JAR=sqlite-jdbc-3.36.0.3.jar

# Compile
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp $SQLITE_JAR *.java

# Run LoginPage
java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -cp .:$SQLITE_JAR LoginPage
```

> 💡 Make sure `sqlite-jdbc-<version>.jar` is in the same directory or update the path accordingly.

---

## 🔑 Keywords for Discovery

`JavaFX`, `Login GUI`, `Signup JavaFX`, `SQLite authentication`, `JavaFX SQLite App`, `Java GUI with database`, `User Login JavaFX`, `Signup screen`, `JavaFX Desktop App`, `Modern Java GUI`, `JDBC`, `Form validation`, `JavaFX project`, `Java Desktop Authentication`

---

## 📃 License

This project is licensed under the [MIT License](LICENSE). You are free to use and modify it for educational or personal use.

---

## 🙌 Author

Built with ❤️ using Java, JavaFX & SQLite.

```

---

Let me know if you'd like:

- A `.zip` with all files + this `README.md`
- Auto-generated `.jar` packaging instructions
- GitHub repo structure initializer (like `.gitignore`, `LICENSE`, etc.)
```
