import java.util.Scanner;

public class StudentGradeCalculator {


    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            boolean continueInput = true;

            while (continueInput) {
                System.out.println("Enter the number of subjects: ");
                int numSubjects = sc.nextInt();

                if (numSubjects <= 0) {
                    System.out.println("Please enter a valid number of subjects.");
                    return;
                }
                int totalMarks = 0;
                int maxMarkPerSubject = 100;

                for (int i = 1; i <= numSubjects; i++) {
                    System.out.println("Enter marks obtained in Subject " + i + " (out of 100):");
                    int marks = sc.nextInt();

                    if (marks < 0 || marks > maxMarkPerSubject) {
                        System.out.println("Marks should be in the range of 0 to 100. Please enter valid marks.");
                        i--; // Decrement i to repeat the subject input
                    } else {
                        totalMarks += marks;
                    }
                }

                double averagePercentage = (double) totalMarks / (numSubjects * maxMarkPerSubject) * 100;
                System.out.println("Total marks: " + totalMarks);
                System.out.println("Average percentage: " + averagePercentage + "%");

                String grade;

                if (averagePercentage >= 90) {
                    grade = "A+";
                } else if (averagePercentage >= 80) {
                    grade = "A";
                } else if (averagePercentage >= 70) {
                    grade = "B";
                } else if (averagePercentage >= 60) {
                    grade = "C";
                } else if (averagePercentage >= 50) {
                    grade = "D";
                } else {
                    grade = "F";
                }
                System.out.println("Grade: " + grade);

                // Ask if the user wants to add another student
                System.out.println("Do you want to enter details for another student? (yes/no)");
                String response = sc.next();
                continueInput = response.equalsIgnoreCase("yes");
            }

            sc.close();
        }
    }







