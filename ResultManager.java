import java.io.*;
import java.util.*;

public class ResultManager {
    private List<Student> students;
    private static final String DATA_FILE = "students_data.txt";
    
    public ResultManager() {
        students = new ArrayList<>();
        loadFromFile();
    }
    
    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully!");
    }
    
    // Search student by roll number
    public Student searchStudent(String rollNo) {
        for (Student s : students) {
            if (s.getRollNo().equalsIgnoreCase(rollNo)) {
                return s;
            }
        }
        return null;
    }
    
    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(100));
        System.out.println("STUDENT RESULT MANAGEMENT SYSTEM - ALL RECORDS");
        System.out.println("=".repeat(100));
        
        for (Student s : students) {
            displayStudentDetails(s);
        }
    }
    
    // Display individual student details
    public void displayStudentDetails(Student s) {
        System.out.println("\n--- Student Result Card ---");
        System.out.println("Roll Number    : " + s.getRollNo());
        System.out.println("Name           : " + s.getName());
        System.out.println("\nSubject Marks:");
        System.out.println("  Mathematics  : " + s.getMathsMarks() + "/100");
        System.out.println("  Physics      : " + s.getPhysicsMarks() + "/100");
        System.out.println("  Chemistry    : " + s.getChemistryMarks() + "/100");
        System.out.println("  English      : " + s.getEnglishMarks() + "/100");
        System.out.println("  Computer     : " + s.getComputerMarks() + "/100");
        System.out.println("\nResult Summary:");
        System.out.println("  Total Marks  : " + s.calculateTotal() + "/500");
        System.out.println("  Percentage   : " + String.format("%.2f%%", s.calculatePercentage()));
        System.out.println("  Grade        : " + s.calculateGrade());
        System.out.println("  Status       : " + s.getResultStatus());
        System.out.println("-".repeat(30));
    }
    
    // Update student marks
    public boolean updateStudent(String rollNo, double maths, double physics, 
                                  double chemistry, double english, double computer) {
        Student s = searchStudent(rollNo);
        if (s != null) {
            s.setMathsMarks(maths);
            s.setPhysicsMarks(physics);
            s.setChemistryMarks(chemistry);
            s.setEnglishMarks(english);
            s.setComputerMarks(computer);
            saveToFile();
            return true;
        }
        return false;
    }
    
    // Delete student
    public boolean deleteStudent(String rollNo) {
        Student s = searchStudent(rollNo);
        if (s != null) {
            students.remove(s);
            saveToFile();
            return true;
        }
        return false;
    }
    
    // Save data to file
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Student s : students) {
                writer.println(s.getRollNo() + "," + s.getName() + "," + 
                             s.getMathsMarks() + "," + s.getPhysicsMarks() + "," + 
                             s.getChemistryMarks() + "," + s.getEnglishMarks() + "," + 
                             s.getComputerMarks());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    
    // Load data from file
    private void loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    Student s = new Student(
                        data[1], data[0],
                        Double.parseDouble(data[2]),
                        Double.parseDouble(data[3]),
                        Double.parseDouble(data[4]),
                        Double.parseDouble(data[5]),
                        Double.parseDouble(data[6])
                    );
                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
    
    // Get top performers
    public void displayTopPerformers(int count) {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort((s1, s2) -> Double.compare(s2.calculatePercentage(), s1.calculatePercentage()));
        
        System.out.println("\n=== TOP " + count + " PERFORMERS ===");
        for (int i = 0; i < Math.min(count, sorted.size()); i++) {
            System.out.println((i + 1) + ". " + sorted.get(i));
        }
    }
    
    public int getTotalStudents() {
        return students.size();
    }
}