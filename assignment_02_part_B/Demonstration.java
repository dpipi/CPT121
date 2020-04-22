package assignment_02_part_B;

public class Demonstration
{

   private final String identifier;
   private final String title;
   private final double baseFee;
   private final int maxAttendees;
   private final int startTime;
   private final int duration;
   private final Object[][] attendees;
   private int attendeeCount;

   Demonstration(String identifier, String title, double baseFee,
                 int maxAttendees, int startTime, int duration)
   {

      this.identifier = identifier;
      this.title = title;
      this.baseFee = baseFee;
      this.maxAttendees = maxAttendees;
      this.startTime = startTime;
      this.duration = duration;

      attendees = new String[maxAttendees][3];
      // bookingsLeft = maxAttendees;
   }

   // gets demonstration identifier
   public String getIdentifier()
   {
      return identifier;
   }

   // gets demonstration title
   public String getTitle()
   {
      return title;
   }

   // gets demonstration base fee
   public double getBaseFee()
   {
      return baseFee;
   }

   // gets demonstration maximum attendees
   public int getMaxAttendees()
   {
      return maxAttendees;
   }

   // gets demonstration start time
   public int getStartTime()
   {
      return startTime;
   }

   // gets demonstration duration
   public int getDuration()
   {
      return duration;
   }

   // gets demonstration attendee count
   public int getAttendeeCount()
   {
      return attendeeCount;
   }

   // gets demonstration attendee name at position
   public String getAttendeeName(int person)
   {
      Object name = attendees[person][0];
      return String.valueOf(name);
   }

   // gets demonstration attendee phone at position
   public String getAttendeePhone(int person)
   {
      Object name = attendees[person][1];
      return String.valueOf(name);
   }

   // getCost takes in one card and returns
   // discounted amount based on calculation
   // card input is percentage of discount
   //
   // @param: --> card1 -> double value
   // @return: -> value -> double value

   public double getCost(double card1)
   {
      // gets base fee for Demonstration
      double amount = getBaseFee();
      // return base fee - discount
      return amount - amount * (card1 / 100);
   }

   // getCost takes in two cards and returns
   // discounted amount based on calculation
   // card input is percentage of discount
   //
   // @param: --> card1 -> double value
   // @param: --> card2 -> double value
   // @return: -> value -> double value

   public double getCost(double card1, double card2)
   {
      // get highest value of all cards
      double max = Math.max(card1, card2);
      // gets base fee for Demonstration
      double baseFeeAmount = getBaseFee();
      // return base fee - discount
      return baseFeeAmount - baseFeeAmount * (max / 100);
   }

   // getCost takes in three cards and returns
   // discounted amount based on calculation
   // card input is percentage of discount
   //
   // @param: --> card1 -> double value
   // @param: --> card2 -> double value
   // @param: --> card3 -> double value
   // @return: -> value -> double value

   public double getCost(double card1, double card2, double card3)
   {
      // get highest value of all cards
      double max = Math.max(card1, (Math.max(card2, card3)));
      // gets base fee for Demonstration
      double baseFeeAmount = getBaseFee();
      // return base fee - discount
      return baseFeeAmount - baseFeeAmount * (max / 100);
   }

   // getCost takes in four cards and returns
   // discounted amount based on calculation
   // card input is percentage of discount
   //
   // @param: --> card1 -> double value
   // @param: --> card2 -> double value
   // @param: --> card3 -> double value
   // @param: --> card4 -> double value
   // @return: -> value -> double value

   public double getCost(double card1, double card2, double card3, double card4)
   {
      // get highest value of all cards
      double max = (Math.max(card1, (Math.max(card2, Math.max(card3, card4)))));
      // gets base fee for Demonstration
      double baseFeeAmount = getBaseFee();
      // return base fee - discount
      return baseFeeAmount - baseFeeAmount * (max / 100);
   }

   // add attendee to Demonstration
   //
   // @array: --> attendees[][] -> stores attendees and details
   // @param: --> attendeeCount -> attendees added to array
   // @param: --> maxAttendees --> maximum attendees for demonstration
   // @return: -> boolean -------> cancelled successful or unsuccessful

   public boolean addAttendee(String name, String phone, double price)
   {
      // if attendee amount not fully booked
      if (attendeeCount < maxAttendees)
      {
         // assign name to array
         attendees[attendeeCount][0] = name;
         // assign phone to array
         attendees[attendeeCount][1] = phone;
         // assign price to array
         attendees[attendeeCount][2] = String.valueOf(price);

         // bookingsLeft--;
         attendeeCount++;
         // attendee added successfully
         return true;
      }
      else
      {
         // attendee not added
         return false;
      }
   }

   // cancel attendee from demonstration
   //
   // @array: -> attendees[][] -> stores attendees and details
   // @param: -> attendeeCount -> attendees added to array
   // @param: -> maxAttendees --> maximum attendees for demonstration
   // @return: -> boolean ------> cancelled successful or unsuccessful

   public boolean cancelAttendee(int choice)
   {
      // set cancellation condition
      boolean cancelled = false;

      // loop through attendees
      for (int i = choice; i < attendeeCount; i++)
      {
         // if attendee details match supplied details
         if ((attendees[i][0]).equals(attendees[choice][0]))
         {
            // loop through attendees
            for (; i < attendees.length - 1; i++)
            {
               // shift array details left
               attendees[i][0] = attendees[i + 1][0];
               attendees[i][1] = attendees[i + 1][1];
               attendees[i][2] = attendees[i + 1][2];
            }
            // remove one attendee from counter
            attendeeCount = attendeeCount - 1;
            // cancellation successful condition
            cancelled = true;
         }
      }
      // return cancelled condition
      return cancelled;
   }

   // get attendee information to display
   //
   // @array: -> attendees[][] -> stores attendees and details
   // @param: -> attendeeCount -> attendees added to array
   // @return: -> boolean ------> cancelled successful or unsuccessful

   public void displayAttendeeInfo()
   {
      // loop through attendees
      for (int i = 0; i < attendeeCount; i++)
      {

         String getPrice = String.valueOf(attendees[i][2]);
         double attendeePrice = Double.parseDouble(getPrice);

         // set up string format for output
         String data =
                  String.format("%d) %-14s: %-14s: $%-14.2f", (i + 1),
                                attendees[i][0], attendees[i][1], attendeePrice);
         System.out.println(data);

      }
      // no attendees , display message
      if (attendeeCount == 0)
      {
         System.out.println("No Attendees");
      }
   }

   // get attendee information to display on screen
   // outputs a basic GUI
   //
   // @param: repeatAmount ------> repeat character "-"
   // @param: LabelSpaces -------> spaces for centering
   // @param: titleSpaces -------> spaces for centering
   // @param: getIdentifier() ---> gets demonstration identifier
   // @param: getTitle() --------> gets demonstration title
   // @param: getBaseFee() ------> gets demonstration base fee
   // @param: getMaxAttendees() -> gets demonstration maximum attendees
   // @param: getStartTime() ----> gets demonstration starting time
   // @param: getDuration() -----> gets demonstration duration

   public void displayEventInfo()
   {
      int repeatAmount = 60;
      int LabelSpaces = (repeatAmount - "ATTENDEES".length()) / 2;
      int titleSpaces;

      // calculate spacing
      if ((repeatAmount - getTitle().length()) / 2 > 0)
      {

         titleSpaces = (repeatAmount - getTitle().length()) / 2;
         repeatAmount = 60;
      }
      else
      {   
         titleSpaces = 0;
         repeatAmount = getTitle().length();
      }

      System.out.println();
      System.out.println("-".repeat(repeatAmount));
      System.out.println(" ".repeat(titleSpaces) + getTitle().toUpperCase());
      System.out.println("-".repeat(repeatAmount));
      System.out.println("Identifier..........: " + getIdentifier());
      System.out.println("Base fee............: $" + getBaseFee());
      System.out.println("Max Attendees.......: " + getMaxAttendees());
      System.out.println("Starting time(24hr) : " + getStartTime());
      System.out.println("Duration............: " + getDuration());
      System.out.println("-".repeat(repeatAmount));
      System.out.println(" ".repeat(LabelSpaces) + "ATTENDEES");
      System.out.println("-".repeat(repeatAmount));
      String title =
               String.format("   %-14s: %-14s: %-14s", "NAME", "PHONE", "PRICE");
      System.out.println(title);
      System.out.println("-".repeat(repeatAmount));
      displayAttendeeInfo();
      System.out.println("-".repeat(repeatAmount));
   }
}
