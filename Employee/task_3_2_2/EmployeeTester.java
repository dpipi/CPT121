package Employee.task_3_2_2;

import java.util.Scanner;

public class EmployeeTester
{
    public static void main(String[] args)
    {
        /* Task 3.1.2 - Interacting with objects */

        // Task A - Create two new Employees Jill and John
        Employee e1 = new Employee("Jill", "Sales", "Manager");
        Employee e2 = new Employee("John", "Legal", "Clerk");

        // Task B - display team and position for jill
        System.out.println("Jills team:" + e1.getTeam());
        System.out.println("Jills position:" + e1.getPosition());

        // Task C - display team and position for john
        System.out.println("Jills team:" + e2.getTeam());
        System.out.println("Jills position:" + e2.getPosition());

        /* Task 3.2.2 - Object manipulation */

        // Task A - Assign desk to Jill
        // .........desk assigned by user
        // .........desk number cant be blank
        Scanner sc = new Scanner(System.in);
        String desk = sc.nextLine();
        // .........update Jills desk number
        boolean deskAssigned = e1.assignDesk(desk);

        // Task B - If desk is valid update desk
        // .........display assigned desk number
        // .........on screen
        if (deskAssigned)
        {
            String deskNumber = e1.getDeskNumber();
            String name = e1.getName();
            System.out.printf("Desk: %s has been assigned to %s",
                              deskNumber, name);
        }

        // Tack C - If desk is not valid reject
        // .........updating of desk and display
        // .........error message
        else
        {
            System.out.println("ERROR - Invalid desk number!");
        }

        sc.close();

    }
}