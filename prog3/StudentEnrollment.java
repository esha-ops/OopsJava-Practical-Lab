/*Question3.
Write a Java program for a university enrollment system using static features.
The program should:
    1. Display a welcome message automatically using a static block.
    2. Maintain a static counter to track how many students have enrolled.
    3. Provide a static method to display the total number of enrolled students.
    4. Create student objects that read three test marks each and use non-static methods to
       compute and display the average of the best two marks.
*/
import java.util.Scanner;

class Student {
    static int count = 0;
    int mark1, mark2, mark3;
    String name;

    static {
        System.out.println("Welcome to the University Enrollment System");
    }

    Student(String name, int mark1, int mark2, int mark3) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        count++;
    }

    void displayAverage() {
        int lowest = Math.min(mark1, Math.min(mark2, mark3));
        double average = (mark1 + mark2 + mark3 - lowest) / 2.0;

        System.out.println("Student: " + name);
        System.out.println("Average of best two marks: " + average);
    }

    static void displayCount() {
        System.out.println("Total enrolled students: " + count);
    }
}

public class StudentEnrollment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for student " + i);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Enter three test marks: ");
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();
            sc.nextLine();

            Student s = new Student(name, m1, m2, m3);
            s.displayAverage();
        }

        Student.displayCount();
        sc.close();
    }
}
