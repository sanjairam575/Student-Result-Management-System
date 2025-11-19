import java.util.Scanner;

public class StudentResultSystem {
    private static ResultManager manager = new ResultManager();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  STUDENT RESULT MANAGEMENT SYSTEM      ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    searchStudentByRoll();
                    break;
                case 3:
                    displayAllRecords();
                    break;
                case 4:
                    updateStudentMarks();
                    break;
                case 5:
                    deleteStudentRecord();
                    break;
                case 6:
                    showTopPerformers();
                    break;
                case 7:
                    System.out.println("\nThank you for using Student Result Management System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(45));
        System.out.println("                 MAIN MENU");
        System.out.println("=".repeat(45));
        System.out.println("1. Add New Student");
        System.out.println("2. Search Student by Roll Number");
        System.out.println("3. Display All Students");
        System.out.println("4. Update Student Marks");
        System.out.println("5. Delete Student Record");
        System.out.println("6. Show Top Performers");
        System.out.println("7. Exit");
        System.out.println("=".repeat(45));
    }
    
    private static void addNewStudent() {
        System.out.println("\n--- Add New Student ---");
        
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Roll Number: ");
        String rollNo = scanner.nextLine();
        
        // Check if roll number already exists
        if (manager.searchStudent(rollNo) != null) {
            System.out.println("Error: Roll number already exists!");
            return;
        }
        
        double maths = getMarks("Mathematics");
        double physics = getMarks("Physics");
        double chemistry = getMarks("Chemistry");
        double english = getMarks("English");
        double computer = getMarks("Computer");
        
        Student student = new Student(name, rollNo, maths, physics, chemistry, english, computer);
        manager.addStudent(student);
        
        System.out.println("\n✓ Student added successfully!");
        manager.displayStudentDetails(student);
    }
    
    private static void searchStudentByRoll() {
        System.out.println("\n--- Search Student ---");
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Enter Roll Number: ");
        String rollNo = scanner.nextLine();
        
        Student student = manager.searchStudent(rollNo);
        if (student != null) {
            manager.displayStudentDetails(student);
        } else {
            System.out.println("Student not found!");
        }
    }
    
    private static void displayAllRecords() {
        manager.displayAllStudents();
        System.out.println("\nTotal Students: " + manager.getTotalStudents());
    }
    
    private static void updateStudentMarks() {
        System.out.println("\n--- Update Student Marks ---");
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Enter Roll Number: ");
        String rollNo = scanner.nextLine();
        
        Student student = manager.searchStudent(rollNo);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.println("Current details:");
        manager.displayStudentDetails(student);
        
        System.out.println("\nEnter new marks:");
        double maths = getMarks("Mathematics");
        double physics = getMarks("Physics");
        double chemistry = getMarks("Chemistry");
        double english = getMarks("English");
        double computer = getMarks("Computer");
        
        if (manager.updateStudent(rollNo, maths, physics, chemistry, english, computer)) {
            System.out.println("\n✓ Marks updated successfully!");
            manager.displayStudentDetails(student);
        }
    }
    
    private static void deleteStudentRecord() {
        System.out.println("\n--- Delete Student Record ---");
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Enter Roll Number: ");
        String rollNo = scanner.nextLine();
        
        Student student = manager.searchStudent(rollNo);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        manager.displayStudentDetails(student);
        System.out.print("\nAre you sure you want to delete this record? (yes/no): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("yes")) {
            if (manager.deleteStudent(rollNo)) {
                System.out.println("✓ Student record deleted successfully!");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    
    private static void showTopPerformers() {
        System.out.print("\nHow many top performers to display? ");
        int count = getIntInput("");
        manager.displayTopPerformers(count);
    }
    
    private static double getMarks(String subject) {
        while (true) {
            System.out.print("Enter marks for " + subject + " (0-100): ");
            double marks = scanner.nextDouble();
            if (marks >= 0 && marks <= 100) {
                return marks;
            }
            System.out.println("Invalid marks! Please enter a value between 0 and 100.");
        }
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}