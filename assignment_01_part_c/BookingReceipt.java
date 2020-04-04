//
// Class BookingReceipt implements methods relevant to
// calculating and printing out a booking receipt, formatted
// as specified in stages A & B.
//

package assignment_01_part_c;

public class BookingReceipt<Scanner> {
    private int receiptNumber;

    BookingReceipt(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String createReceipt() {
        String receipt = "MHT" + String.valueOf(this.receiptNumber);
        receiptNumber++;
        return receipt;
    }

    public void displayReceipt(String newReceipt, Object[] selection) {

        // Method takes String newReceipt for receipt number
        // Method takes Object[] selection for detail extraction

        // selection[0] = 0 : "Castlemaine"
        // selection[0] = 1 : "Campbell"
        // selection[0] = 2 : "Guildford"
        // selection[0] = 3 : "Strangway"
        // selection[0] = 4 : "Newstead"
        // selection[0] = 5 : "Moolort"
        //
        // selection[1] = 0 : "Castlemaine"
        // selection[1] = 1 : "Campbell"
        // selection[1] = 2 : "Guildford"
        // selection[1] = 3 : "Strangway"
        // selection[1] = 4 : "Newstead"
        // selection[1] = 5 : "Moolort"
        //
        // selection[2] = "First Class"
        // selection[2] = "Standard Class"
        // selection[2] = "Excursion Class"
        //
        // selection[3] = No of adult tickets
        // selection[4] = No of child paid tickets
        // selection[5] = No of child free tickets

        // Initialize string variable
        String boardingName = "";
        String departingName = "";

        // assign station name for boarding label on receipt
        // selection[0] = boarding station
        //
        if ((int) selection[0] == (0)) {
            boardingName = "Castlemaine";
        } else if ((int) selection[0] == 1) {
            boardingName = "Campbell";
        } else if ((int) selection[0] == 2) {
            boardingName = "Guildford";
        } else if ((int) selection[0] == 3) {
            boardingName = "Strangway";
        } else if ((int) selection[0] == 4) {
            boardingName = "Newstead";
        } else if ((int) selection[0] == 5) {
            boardingName = "Moolort";
        }

        // assign station name for departing label on receipt
        // selection[1] = departing station
        //
        if ((int) selection[1] == 0) {
            departingName = "Castlemaine";
        } else if ((int) selection[1] == 1) {
            departingName = "Campbell";
        } else if ((int) selection[1] == 2) {
            departingName = "Guildford";
        } else if ((int) selection[1] == 3) {
            departingName = "Strangway";
        } else if ((int) selection[1] == 4) {
            departingName = "Newstead";
        } else if ((int) selection[1] == 5) {
            departingName = "Moolort";
        }

        // number of total adult tickets
        int adultPaidTickets = 0;

        // selection[3] = adult tickets
        if (selection[3] == null) // if null set to 0
        {
            adultPaidTickets = 0;
        } else {
            adultPaidTickets = (int) selection[3];
        }

        // number of total child paid tickets
        int childPaidTickets = 0;
        // get totals for each ticket type
        if (selection[4] == null) // if null set to 0
        {
            childPaidTickets = 0;
        } else {
            childPaidTickets = (int) selection[4];
        }

        // number of total free tickets
        int childFreeTickets = 0;
        // get totals for each ticket type
        if (selection[5] == null) // if null set to 0
        {
            childFreeTickets = 0;
        } else {
            childFreeTickets = (int) selection[5];
        }

        // calculate total ticket
        // @SuppressWarnings("unused")
        // int totalTickets = adultPaidTickets + childPaidTickets + childFreeTickets;
        // total costs of tickets for class
        double totalCost = 0;

        // calculate number of stops
        int stops = (int) selection[1] - (int) selection[0];

        // header layout for receipt label
        System.out.println("\n".repeat(4));
        System.out.println("-".repeat(80));
        System.out.println("                   Moolort Heritage Railway");
        System.out.println("-".repeat(80));
        System.out.println("Receipt  : " + newReceipt);
        System.out.println("Boarding : " + boardingName);
        System.out.println("Departing: " + departingName);
        System.out.println("-".repeat(80));

        // select display based on ticket type
        if (selection[2] == "First Class") {
            System.out.printf("%d\tAdult Paid tickets @ $16  per stop -> %d STOPS * $16 -> TOTAL  = $%d\n",
                    adultPaidTickets, stops, stops * 16 * adultPaidTickets);

            // Get total cost for all first class tickets
            totalCost = (stops * 16 * adultPaidTickets);
        } else if (selection[2] == "Standard Class") {
            System.out.printf("%d\tAdult Paid tickets @ $11  per stop -> %d STOPS * $11 -> TOTAL  = $%d\n",
                    adultPaidTickets, stops, stops * 11 * adultPaidTickets);
            System.out.println("-".repeat(80));
            System.out.printf("%d\tChild Paid tickets @ $6   per stop -> %d STOPS * $6  -> TOTAL  = $%d\n",
                    childPaidTickets, stops, stops * 6 * childPaidTickets);
            System.out.println("-".repeat(80));
            System.out.printf("%d\tChild Free tickets @ FREE per stop -> %d STOPS * $0  -> TOTAL  = FREE\n",
                    childFreeTickets, stops);

            // Get total cost for all Standard class tickets
            totalCost = (stops * 11 * adultPaidTickets) + (stops * 6 * childPaidTickets)
                    + (stops * 0 * childFreeTickets);
        } else if (selection[2] == "Excursion Class") {
            System.out.printf("%d\tAdult Paid tickets @ $8   per stop -> %d STOPS * $8 -> TOTAL  = $%d\n",
                    adultPaidTickets, stops, stops * 8 * adultPaidTickets);
            System.out.println("-".repeat(80));
            System.out.printf("%d\tChild Paid tickets @ $4   per stop -> %d STOPS * $4 -> TOTAL  = $%d\n",
                    childPaidTickets, stops, stops * 4 * childPaidTickets);
            System.out.println("-".repeat(80));
            System.out.printf("%d\tChild Free tickets @ FREE per stop -> %d STOPS * $0 -> TOTAL  = FREE\n",
                    childFreeTickets, stops);

            // Get total cost for all Standard class tickets
            totalCost = (stops * 8 * adultPaidTickets) + (stops * 4 * childPaidTickets)
                    + (stops * 0 * childFreeTickets);
        }

        double discount = 0;
        if (adultPaidTickets + childPaidTickets >= 10) {
            discount = (totalCost * 10) / 100;
            System.out.println("-".repeat(80));
            System.out.println("\t\t\t\t\t\t\t  10% Dicount = $" + (int) discount);

            System.out.printf("\t\t\t\t\t\t\t -----------------------\n");
            // receipt label details for fees, discount and total cost

            System.out.printf("\t\t\t\t\t\t\t  Booking Fee = $5\n");
            System.out.printf("\t\t\t\t\t\t\t -----------------------\n");
            System.out.printf("\t\t\t\t\t\t\t  *Total Cost = $%d\n", (int) totalCost - (int) discount + 5);
            System.out.printf("\t\t\t\t\t\t\t -----------------------\n");
        } else {
            // receipt label details for fees, discount and total cost
            System.out.println("-".repeat(80));
            System.out.printf("\t\t\t\t\t\t\t  Booking Fee = $5\n");
            System.out.printf("\t\t\t\t\t\t\t -----------------------\n");
            System.out.printf("\t\t\t\t\t\t\t  *Total Cost = $%d\n", (int) (totalCost) + 5);
            System.out.printf("\t\t\t\t\t\t\t -----------------------\n");
            System.out.println();
            System.out.println();
        }

    }
}
