# 🏠 RentHouse - Full Stack CRUD Application

A full-stack application to manage rental house listings. Users can create, read, update, and delete (CRUD) property entries through a modern web interface.

---

## 📌 Technologies Used

| Layer     | Tech Stack                              |
|-----------|------------------------------------------|
| Backend   | Java 21, Spring Boot, Spring Data JPA, PostGres |
| Frontend  | React.js, Axios, React Router DOM       |
| Database  | PostGres                                   |
| Tools     | Git, Maven                |

---

## 📁 Project Structure

renting-house-app/
├── backend/
│   ├── src/main/java/com/example/backend/  (code backend Java)
│   ├── src/main/resources/                    (configurations)
│   └── pom.xml
├── frontend/
│   ├── src/components/                        (composants React)
│   ├── App.js                                (router principal)
│   └── package.json
└── README.md


## 🛠️ Installation & Setup

1. **Clone the repository**  
Open your terminal and run: 
git clone https://github.com/FdSouad/renting-house-app.git
cd your-repo


2. **Set up PostgreSQL**  
- Download and install PostgreSQL from [https://www.postgresql.org/download/](https://www.postgresql.org/download/)  
- Create a database named `renting_db` by running the SQL command:  
- Remember your PostgreSQL username and password (e.g., `postgres` / `postgres123`).

3. **Configure and run the backend**  
- Open the `backend` folder in your IDE (IntelliJ recommended)  
- Edit `src/main/resources/application.properties` to set your database connection:  

- Run the Spring Boot application by executing the main class `BackendApplication`  
- The backend API will be available at `http://localhost:8080/api/houses`.

4. **Configure and run the frontend**  
- Open a terminal and navigate to the `frontend` directory  
- Install dependencies by running: 
    npm install
    npm start
- Open your browser at [http://localhost:3000](http://localhost:3000) to access the frontend.
 

