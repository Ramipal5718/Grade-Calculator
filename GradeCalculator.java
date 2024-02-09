import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Initialize variables
        int totalMarks = 0;
        int maxMarksPerSubject = 100;

        // Input marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of " + maxMarksPerSubject + "): ");
            int subjectMarks = scanner.nextInt();

            // Validate input marks
            if (subjectMarks < 0 || subjectMarks > maxMarksPerSubject) {
                System.out.println("Invalid marks. Marks should be between 0 and " + maxMarksPerSubject + ". Try again.");
                i--; // Decrement i to re-enter marks for the same subject
            } else {
                totalMarks += subjectMarks;
            }
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / (numSubjects * maxMarksPerSubject) * 100;

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + calculateGrade(averagePercentage));

        scanner.close();
    }

    // Function to calculate the grade based on the average percentage
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}