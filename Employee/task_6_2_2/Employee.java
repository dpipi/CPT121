package Employee.task_6_2_2;

public class Employee
{
    // instance variables
    private String name;
    private String team;
    private String position;
    private String deskNumber;

    // constructor
    public Employee(String name, String team, String position)
    {
        this.name = name;
        this.team = team;
        this.position = position;
        this.deskNumber = "TBC";
    }

    // accessors (Getter) methods
    public String getName()
    {
        return name;
    }

    public String getTeam()
    {
        return team;
    }

    public String getPosition()
    {
        return position;
    }

    public String getDeskNumber()
    {
        return deskNumber;
    }

    // helper methods
    public void printDetails()
    {
        System.out.printf("%-10s%s\n", "Name:", name);
        System.out.printf("%-10s%s\n", "Team:", team);
        System.out.printf("%-10s%s\n", "Position:", position);
        System.out.printf("%-10s%s\n", "Desk:", deskNumber);

    }

    // mutator's (setter) methods
    public boolean assignDesk(String deskNumber)
    {
        if (deskNumber.isEmpty())
        {
            return false;
        }
        else
        {
            this.deskNumber = deskNumber;
            return true;
        }
    }

}