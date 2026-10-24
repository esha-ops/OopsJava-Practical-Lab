/*Question 1: Employee Database
Write a Java program to maintain an Employee database using
an array of objects.
Each Employee record should store: name, employee ID,
department, age, designation, and salary.
The program must perform the following tasks:
1. Read and display details of at least five employees.
2. Compute and print the total salary of all employees
   working in the Sales department.
3. Identify and display the details of the highest paid
   manager in the Purchase department.*/

import java.util.Scanner;

class Employee {
    String name, department, designation;
    int empId, age;
    double salary;

    Employee(String name, int empId, String department,
             int age, String designation, double salary) {
        this.name = name;
        this.empId = empId;
        this.department = department;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Department: " + department);
        System.out.println("Age: " + age);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
        System.out.println("--------------------");
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] emp = new Employee[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details of employee " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Employee ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Designation: ");
            String desig = sc.nextLine();

            System.out.print("Salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            emp[i] = new Employee(name, id, dept, age, desig, salary);
        }

        double salesTotal = 0;
        Employee manager = null;

        for (Employee e : emp) {
            e.display();

            if (e.department.equalsIgnoreCase("Sales")) {
                salesTotal += e.salary;
            }

            if (e.department.equalsIgnoreCase("Purchase")
                    && e.designation.equalsIgnoreCase("Manager")) {
                if (manager == null || e.salary > manager.salary) {
                    manager = e;
                }
            }
        }

        System.out.println("Total Sales Department Salary: " + salesTotal);

        if (manager != null) {
            System.out.println("Highest Paid Purchase Manager:");
            manager.display();
        } else {
            System.out.println("No manager found in Purchase department.");
        }

        sc.close();
    }
}
