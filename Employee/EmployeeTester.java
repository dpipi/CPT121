package Employee;

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

    }
}