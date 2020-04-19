package Employee.task_5_2_2;

import java.util.Scanner;

public class EmployeeTester {
    private static int totalEmployees = 4;
    private static Employee[] employees = new Employee[totalEmployees];
    private static int employeeCount = 0;

    public static void main(String[] args) {
        /* Task 5.1.2 - Populating arrays */

        Scanner sc = new Scanner(System.in);
        // Employee e;
        // String name;
        String target;
        String deskNumber;

        // assign employee to save manual input in this example
        Employee e1 = new Employee("Jill", "Sales", "Manager");
        Employee e2 = new Employee("Jack", "Sales", "Clerk");
        Employee e3 = new Employee("Joan", "Legal", "Manager");
        Employee e4 = new Employee("Jeff", "Legal", "Clerk");

        // Populate arrays with employee objects
        employees[0] = e1;
        employees[1] = e2;
        employees[2] = e3;
        employees[3] = e4;

        // update employee count to match manual assignment
        employeeCount = 4;

        // display all employee details
        for (int i = 0; i < employeeCount; i++) {
            employees[i].printDetails();
            System.out.println();
        }

        // Search for employee
        System.err.print("Enter name of employee: ");
        target = sc.nextLine();

        // set temporary employee reference to null
        Object e = null;

        // Locate matching employee in array
        for (int i = 0; i < employeeCount && e == null; i++) {
            String name = employees[i].getName();

            // check if name = target
            if (name.equalsIgnoreCase(target)) {
                e = employees[i];
            }
        }

        // test for failed search
        if (e == null) { // search is unsuccessful
            System.out.printf("ERROR - %s not found!", target);
        } else // search is successful
        {
            System.out.print("Enter desk number: ");
            deskNumber = sc.nextLine();

            // attempt to assign desk number
            boolean deskAssigned = ((Employee) e).assignDesk(deskNumber);

            // test if assignment was successful
            if (deskAssigned) {
                System.out.println("Desk assigned successfully!");
            } else {
                System.out.println("ERROR - Invalid desk number!");
            }

            // close scanner after use
            sc.close();

        }

    }
    
}