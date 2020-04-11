package Employee.task_5_1_2;

import java.util.Scanner;

public class EmployeeTester
{
    private static int totalEmployees = 10;
    private static Employee[] employees = new Employee[totalEmployees];
    private static int employeeCount = 0;

    public static void main(String[] args)
    {
        /* Task 5.1.2 - Populating arrays */

        Scanner sc = new Scanner(System.in);
        String name, team, position;
        String answer;
        Employee e;

        do
        {
            // Task A - Prompt user for details

            // get employee name
            System.out.print("Enter name: ");
            name = sc.nextLine();

            // get employee name
            System.out.print("Enter team: ");
            team = sc.nextLine();

            // get employee name
            System.out.print("Enter position: ");
            position = sc.nextLine();

            // Task B - create new employee object
            e = new Employee(name, team, position);

            // Task C - store object in array
            employees[employeeCount] = e;
            employeeCount++;

            if (employeeCount == totalEmployees)
            {
                answer = "N";
            }
            else
            {
                // ask wether to continue
                System.out.print("Do you wish to continue (Y/N)? ");
                answer = sc.nextLine();
            }

        } while (answer.equalsIgnoreCase("Y") && employeeCount < employees.length);

        sc.close();

        for (int i = 0; i < employeeCount; i++)
        {
            employees[i].printDetails();
            System.out.println();
        }

    }
}