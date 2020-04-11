package Employee.task_6_1_2;

import java.util.Scanner;

public class EmployeeTester
{
    private static int totalEmployees = 4;
    private static Employee[] employees = new Employee[totalEmployees];
    private static int employeeCount = 0;

    public static void main(String[] args)
    {
        Clerk c1 = new Clerk("Jack", "Research", 
                             "Finance");

        c1.printDetails();

    }
}