package assignment_02_part_A;

public class TestHarness {



    public static void main(String[] args) {

        String details;
        String identifier = "d123";
        String title = "Inspect and prepare a heritage steam locomotive";
        double baseFee = 100;
        int maxAttendees = 3;
        int startingTime = 10;
        int duration = 180;

        //double price;

        Demonstration d123 = new Demonstration(identifier, title, baseFee,
                                                maxAttendees, startingTime,
                                                duration);

        // Demonstrate short hand display
        details =  String.format("Identifier    : %s\n", d123.getIdentifier());
        details += String.format("Title         : %s\n",d123.getTitle());
        details += String.format("Base fee      : $%.2f\n",d123.getBaseFee());
        details += String.format("Max attendees : %d\n",d123.getMaxAttendees());
        details += String.format("Starting time : %d\n",d123.getStartTime());
        details += String.format("Duration      : %d\n",d123.getDuration());
        System.out.println(details);

        // Demonstrate no membership costs
        //price = d123.getCost();
        //System.out.printf("$%.2f\n",price);

        // // Consession costs
        // price = d123.getCost("concession");
        // System.out.printf("$%.2f\n",price);

        // // FSRS Costs
        // price = d123.getCost("FSRS");
        // System.out.printf("$%.2f\n",price);

        // // ARHS Costs
        // price = d123.getCost("ARHS");
        // System.out.printf("$%.2f\n",price);

        // // MHR Costs
        // price = d123.getCost("MHR");
        // System.out.printf("$%.2f\n",price);

        // // All types costs
        // price = d123.getCost("concession","FSRS", "ARHS", "MHR");
        // System.out.printf("$%.2f\n",price);

        // // Add attendee
        // price = d123.getCost();
        // boolean booking1 = d123.addAttendee("R.Sharma", "555-2277", price);
        // System.out.println("Booking1: " + booking1);

        // // Add attendee
        // price = d123.getCost("ARHS");
        // double cost1 = d123.getCost("ARHS");
        // boolean booking2 = d123.addAttendee("B.Jones", "555-1234", price);
        // System.out.println("Booking2: " + booking2);

        // // Add attendee
        // price = d123.getCost("FSRS");
        // boolean booking3 = d123.addAttendee("K.Nguyen", "555-9999", price);
        // System.out.println("Booking3: " + booking3);

        // price = d123.getCost("MHR");
        // boolean booking7 = d123.addAttendee("Foster", "555-6060", price);
        // System.out.println("Booking7: " + booking7);

        // // Add attendee


        // System.out.println();
        // d123.getAttendeeInfo();
        // System.out.println();

        // d123.cancelAttendee("r.sharma");

        // System.out.println();
        // d123.getAttendeeInfo();
        // System.out.println();

        // price = d123.getCost("MHR");
        // boolean booking4 = d123.addAttendee("D.Vadar", "555-6060", price);
        // System.out.println("Booking4: " + booking4);

        // System.out.println();
        // d123.getAttendeeInfo();
        // System.out.println();

        // d123.cancelAttendee("K.Nguyen");



    }
}