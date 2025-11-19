💻 1. Java Console Application
The Java implementation is a command-line interface (CLI) application that uses simple file I/O for persistent data storage.

📁 Project Structure
Student.java: Defines the Student object with properties for name, roll number, and subject marks. It includes methods for calculating total marks, percentage, and grade.

ResultManager.java: Handles the core logic, including adding, searching, updating, deleting, and displaying student records. It manages the list of students and handles saving/loading data to a file (students_data.txt).

StudentResultSystem.java: The main class containing the user interface (main menu) and all the interactive functions that drive the application.

✨ Features
Add New Student: Register a new student with their name, roll number, and marks in 5 subjects (Mathematics, Physics, Chemistry, English, Computer).

Search Student by Roll Number: Retrieve and display the result card for a specific student.

Display All Students: List all stored student records with their summary results.

Update Student Marks: Modify the subject marks for an existing student.

Delete Student Record: Remove a student's record from the system.

Show Top Performers: Display students sorted by percentage, highlighting the top performers.

Data Persistence: Data is saved to and loaded from a local file (students_data.txt).

🌐 Student Result Management System (Web Application)
This is a modern, single-page web application designed to manage and calculate student results instantly. It is built using standard web technologies: HTML, CSS, and vanilla JavaScript, and uses the browser's Local Storage for data persistence.

✨ Key Features
Clean, Responsive Interface: The application features a clean, purple/blue gradient design, making it easy to use on different screen sizes.

Tabbed Navigation: Information is organized into three main sections: "Add Student," "Search Student," and "All Students".

Instant Result Calculation: As soon as a student is added, their total marks, percentage, grade, and status (PASS/FAIL) are calculated and displayed in a detailed Result Card.

Result Persistence: All student data is stored locally within the user's browser using localStorage, so records remain saved even after closing the tab.

Performance Tracking: The "All Students" tab lists all records, sorted by percentage, to easily identify top performers.

Color-Coded Grades: Results are visually enhanced with colorful badges for grades (A+, A, B+, etc.).

