import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String rollNo;
    private double mathsMarks;
    private double physicsMarks;
    private double chemistryMarks;
    private double englishMarks;
    private double computerMarks;
    
    // Constructor
    public Student(String name, String rollNo, double mathsMarks, 
                   double physicsMarks, double chemistryMarks, 
                   double englishMarks, double computerMarks) {
        this.name = name;
        this.rollNo = rollNo;
        this.mathsMarks = mathsMarks;
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.englishMarks = englishMarks;
        this.computerMarks = computerMarks;
    }
    
    // Calculate total marks
    public double calculateTotal() {
        return mathsMarks + physicsMarks + chemistryMarks + englishMarks + computerMarks;
    }
    
    // Calculate percentage
    public double calculatePercentage() {
        return (calculateTotal() / 500) * 100;
    }
    
    // Calculate grade based on percentage
    public String calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B+";
        else if (percentage >= 60) return "B";
        else if (percentage >= 50) return "C";
        else if (percentage >= 40) return "D";
        else return "F";
    }
    
    // Get result status
    public String getResultStatus() {
        return calculatePercentage() >= 40 ? "PASS" : "FAIL";
    }
    
    // Getters
    public String getName() { return name; }
    public String getRollNo() { return rollNo; }
    public double getMathsMarks() { return mathsMarks; }
    public double getPhysicsMarks() { return physicsMarks; }
    public double getChemistryMarks() { return chemistryMarks; }
    public double getEnglishMarks() { return englishMarks; }
    public double getComputerMarks() { return computerMarks; }
    
    // Setters
    public void setName(String name) { this.name = name; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
    public void setMathsMarks(double mathsMarks) { this.mathsMarks = mathsMarks; }
    public void setPhysicsMarks(double physicsMarks) { this.physicsMarks = physicsMarks; }
    public void setChemistryMarks(double chemistryMarks) { this.chemistryMarks = chemistryMarks; }
    public void setEnglishMarks(double englishMarks) { this.englishMarks = englishMarks; }
    public void setComputerMarks(double computerMarks) { this.computerMarks = computerMarks; }
    
    @Override
    public String toString() {
        return String.format(
            "Roll No: %s | Name: %s | Total: %.2f | Percentage: %.2f%% | Grade: %s | Status: %s",
            rollNo, name, calculateTotal(), calculatePercentage(), 
            calculateGrade(), getResultStatus()
        );
    }
}