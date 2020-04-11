package Employee.task_3_1_2;

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

    // accessors
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

}