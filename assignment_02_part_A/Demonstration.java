package assignment_02_part_A;

public class Demonstration {

   private final String identifier;
   private final String title;
   private final double baseFee;
   private final int maxAttendees;
   private final int startTime;
   private final int duration;

   private final Object[][] attendees;
   private int attendeeCount;
   // private int bookingsLeft;

   Demonstration(String identifier, String title, double baseFee, int maxAttendees, int startTime, int duration) {

      this.identifier = identifier;
      this.title = title;
      this.baseFee = baseFee;
      this.maxAttendees = maxAttendees;
      this.startTime = startTime;
      this.duration = duration;

      attendees = new String[maxAttendees][3];
      // bookingsLeft = maxAttendees;
   }

   // Getter methods
   public String getIdentifier() {
      return identifier;
   }

   public String getTitle() {
      return title;
   }

   public double getBaseFee() {
      return baseFee;
   }

   public int getMaxAttendees() {
      return maxAttendees;
   }

   public int getStartTime() {
      return startTime;
   }

   public int getDuration() {
      return duration;
   }

   public int getAttendeeCount() {
      return attendeeCount;
   }

   // public int getBookingsLeft()
   // {
   // return bookingsLeft;
   // }

   public String getAttendeeName(int person) {
      Object name = attendees[person][0];
      return String.valueOf(name);
   }

   // getCost takes in card amounts from 1 to 4
   // and returns discounted amount is type double
   //
   // @param --> card1 : double 10
   // @param --> card2 : double 20
   // @param --> card3 : double 25
   // @param --> card4 : double 100
   // @return -> calculation

   // return cost for one card type
   public double getCost(double card1) {
      double amount = getBaseFee();
      return amount - amount * (card1 / 100);
   }

   // return cost for two card types
   public double getCost(double card1, double card2) {
      double max = Math.max(card1, card2);
      double baseFeeAmount = getBaseFee();
      return baseFeeAmount - baseFeeAmount * (max / 100);
   }

   // return cost for three card types
   public double getCost(double card1, double card2, double card3) {
      double max = Math.max(card1, (Math.max(card2, card3)));
      double baseFeeAmount = getBaseFee();
      return baseFeeAmount - baseFeeAmount * (max / 100);
   }

   // return cost for four card types
   public double getCost(double card1, double card2, double card3, double card4) {
      double max = (Math.max(card1, (Math.max(card2, Math.max(card3, card4)))));
      double baseFeeAmount = getBaseFee();
      return baseFeeAmount - baseFeeAmount * (max / 100);

   }

   // add attendee to Demonstration
   public boolean addAttendee(String name, String phone, double price) {
      if (attendeeCount < maxAttendees) {

         attendees[attendeeCount][0] = name.toUpperCase();
         attendees[attendeeCount][1] = phone;
         attendees[attendeeCount][2] = String.valueOf(price);

         // bookingsLeft--;
         attendeeCount++;

         return true;
      } else {
         return false;
      }
   }

   // attendees[i][0] = i -->
   // cancel attendee
   public boolean cancelAttendee(int choice) {
      // attendee = attendee.toUpperCase();
      boolean cancelled = false;
      for (int i = 0; i < attendeeCount; i++) {
         if ((attendees[i][0]).equals(attendees[choice][0])) {

            for (; i < attendees.length - 1; i++) {
               attendees[i][0] = attendees[i + 1][0];
               attendees[i][1] = attendees[i + 1][1];
               attendees[i][2] = attendees[i + 1][2];
            }
            // bookingsLeft = bookingsLeft + 1;
            attendeeCount = attendeeCount - 1;
            cancelled = true;
         }
      }
      return cancelled;
   }

   // Helper Methods

   // get attendee information to display
   public void displayAttendeeInfo() {
      for (int i = 0; i < attendeeCount; i++) {
         String data = String.format("%d) %-14s: %-14s: %-14s", (i + 1), attendees[i][0], attendees[i][1],
               attendees[i][2]);
         System.out.println(data);

      }
      if (attendeeCount == 0) {
         System.out.println("No Attendees");
      }
   }

   // get attendee information to display
   public void displayEventInfo() {
      int repeatAmount = 60;
      int LabelSpaces = (repeatAmount - "ATTENDEES".length()) / 2;
      int titleSpaces;

      if ((repeatAmount - getTitle().length()) / 2 > 0) {
         titleSpaces = (repeatAmount - getTitle().length()) / 2;
         repeatAmount = 60;
      } else {
         titleSpaces = 0;
         repeatAmount = getTitle().length();
      }

      System.out.println();
      System.out.println("-".repeat(repeatAmount));
      System.out.println(" ".repeat(titleSpaces) + getTitle().toUpperCase());
      System.out.println("-".repeat(repeatAmount));
      System.out.println("Identifier..........: " + getIdentifier());
      System.out.println("Base fee............: " + getBaseFee());
      System.out.println("Max Attendees.......: " + getMaxAttendees());
      System.out.println("Starting time(24hr) : " + getStartTime());
      System.out.println("Duration............: " + getDuration());
      System.out.println("-".repeat(repeatAmount));
      System.out.println(" ".repeat(LabelSpaces) + "ATTENDEES");
      System.out.println("-".repeat(repeatAmount));
      String title = String.format("   %-14s: %-14s: %-14s", "NAME", "PHONE", "PRICE");
      System.out.println(title);
      System.out.println("-".repeat(repeatAmount));
      displayAttendeeInfo();
      System.out.println("-".repeat(repeatAmount));
   }
}
