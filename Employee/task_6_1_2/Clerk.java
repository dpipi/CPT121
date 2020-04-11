package Employee.task_6_1_2;

public class Clerk extends Employee
{

    private String department;

    private String[] contractsAssigned = new String[3];
    private int numContracts = 0;

    public Clerk(String name, String team,
                 String department)
    {
        super(name, team);
        this.department = department;

    }

    public void printDetails()
    {
        System.out.printf("%-10s%s\n", "Department:", department);

    }
}