//StudentGradeCalculator

import java.util.Scanner;
public class Codsoft2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalSubjects = 5;

        //Take marks obtained (out of 100) in each subject
        int[] marks = new int[totalSubjects];
        for(int i = 0; i < marks.length; i++){
            System.out.println("Enter marks obtained in subject "+(i+1));
            marks[i] = sc.nextInt();
        }

        //Calculate Total Marks: Sum up the marks obtained in all subjects
        int totalMarks = 0;
        for(int i = 0; i < marks.length; i++){
            totalMarks += marks[i];
        }

        //Calculate Average Percentage: Divide the total marks by the total number of subjects to get the average percentage
        double averagePercentage = totalMarks / marks.length;

        //Grade Calculation: Assign grades based on the average percentage achieved.
        char grade = ' ';
        if(averagePercentage >= 80)
            grade = 'O';
        else if(averagePercentage >= 70)
            grade = 'A';
        else if(averagePercentage >= 60)
            grade = 'B';
        else if(averagePercentage >= 50)
            grade = 'C';
        else if(averagePercentage >= 40)
            grade = 'D';
        else
            grade = 'F';

        //Display Results: Show the total marks, average percentage, and the corresponding grade to the user
        System.out.println("Total marks obtained are " + totalMarks);
        System.out.println("Average percentege is " + averagePercentage);
        System.out.println("Grade is " + grade);

        sc.close();
    }
}
