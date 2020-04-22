package assignment_02_part_B;

import java.util.Scanner;

/**
 * Demonstration of a fictional train system program for booking demonstration events
 */

public class ProgMgmtSys

{
   // set variable for maximum demonstration events
   private static int maxDemos = 5;
   // set array for demonstration storage
   private static Demonstration[] demonstrations = new Demonstration[maxDemos];
   // set variable to keep track of total demonstrations
   private static int demonstrationCounter = 0;

   // program main method
   public static void main(String[] args)
   {
      // create scanner for user input
      Scanner sc = new Scanner(System.in);

      // set common menu error message
      String errorMsg = "\nERROR -> PLEASE ENTER A DEMONSTRATION";

      boolean exit = false;
      do
      {
         // setup menu message
         String menuMsg = "\nMOOLORT HERITAGE RAILWAY\n";
         menuMsg += "------------------------\n";
         menuMsg += "1) Add demonstration\n";
         menuMsg += "2) Add attendee\n";
         menuMsg += "3) View one event\n";
         menuMsg += "4) View all events\n";
         menuMsg += "5) View statistics\n";
         menuMsg += "6) Cancel attendee\n";
         menuMsg += "7) Cancel demonstration\n";
         menuMsg += "X) Exit\n";
         menuMsg += "Choice:";

         // display menu
         System.out.print(menuMsg);

         // get user choice
         String choice = sc.nextLine().toLowerCase();

         switch (choice)
         {
            case "1":
               addDemonstration(sc);
               break;
            case "2":
               // demonstration has been added
               if (demonstrationCounter > 0)
               {
                  addAttendee(sc);
               }
               else
               {
                  // no demonstrations has been added
                  System.out.println(errorMsg);
               }
               break;
            case "3":
               // demonstration has been added
               if (demonstrationCounter > 0)
               {
                  viewOneDemonstration(sc);
               }
               else
               {
                  // no demonstrations has been added
                  System.out.println(errorMsg);
               }

               break;
            case "4":
               // demonstration has been added
               if (demonstrationCounter > 0)
               {
                  viewAllDemonstrations();
               }
               else
               {
                  // no demonstrations has been added
                  System.out.println(errorMsg);
               }

               break;
            case "5":
               // demonstration has been added
               if (demonstrationCounter > 0)
               {
                  viewStatistics();
               }
               else
               {
                  // no demonstrations has been added
                  System.out.println(errorMsg);
               }
               break;
            case "6":
               // demonstration has been added
               if (demonstrationCounter > 0)
               {
                  cancelAttendee(sc);
               }
               else
               {
                  // no demonstrations has been added
                  System.out.println(errorMsg);
               }
               break;
            case "7":
               // demonstration has been added
               if (demonstrationCounter > 0)
               {
                  cancelDemonstration(sc);
               }
               else
               {
                  // no demonstrations has been added
                  System.out.println(errorMsg);
               }
               break;
            case "x": // exit program
               exit = true;
               break;
            default:
               System.out.println("ERROR -> INVALID CHOICE\n");
         }
      } while (!exit);
      sc.close();
      System.out.println("GoodBye!");
   }

   // OPTION 1 - ADD DEMONSTRATION
   //
   // if more than one demonstration has been created
   // checks to see if identifier entered by user has
   // been previously used, if no demonstrations have
   // previously created excepts the first one entered
   // also checks that first letter of identifier is
   // either a d - Demonstration. or w - workshop
   //
   // @param: demonstrationCounter -> integer -> Number of demonstrations
   // @param: eventIdExist ---------> boolean -> While event id exists loop
   // @param: eventIDLengthZero ----> Boolean -> While input length = 0
   // ...........................................and identifier does not
   // ...........................................start with d or w.
   // @param: identifier -----------> String --> Scanner input from user
   // @Object: demonstrations[i] ---> Array ---> Stores created demonstrations

   private static void addDemonstration(Scanner sc)
   {
      // if array not full
      if (demonstrationCounter < maxDemos)
      {

         // initialize variable
         String identifier;

         if (demonstrationCounter > 0)
         {
            // set do/while exit condition
            boolean eventIdExists = true;
            do
            {
               // set boolean variable to test that
               // length of input is greater than 0
               boolean eventIDLengthZero = true;
               do
               {

                  // get user to enter demonstration identifier
                  System.out.print("ENTER -> Demonstration Identifier: ");
                  identifier = sc.nextLine().toLowerCase();

                  // if identifier length is greater
                  // than 0 continue, test input
                  if (identifier.length() > 0)
                  {

                     // user selected exit
                     if (identifier.matches("x"))
                     {
                        // return to main menu
                        return;
                     }

                     // test if identifier starts with correct letters
                     // d -> Demonstration
                     // w -> Workshops <- Future update
                     else if (identifier.startsWith("d") ||
                              identifier.startsWith("w"))
                     {
                        // all input OK
                        eventIDLengthZero = false;
                     }

                     // input not correct
                     else
                     {

                        System.out
                                 .println("ERROR -> IDENTIFIER MUST START WITH D OR W\n");
                     }

                  }
                  // first
                  else
                  {
                     // user has not entered a valid input
                     // show user an error message
                     System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
                  }

               } while (eventIDLengthZero); // until valid identifier
                                            // has been entered

               // cycle through events checking for
               // any matching event identifications
               for (int i = 0; i < demonstrationCounter; i++)
               {
                  // demonstration identification number is not
                  // unique and has matched one stored in array
                  if (demonstrations[i].getIdentifier().equalsIgnoreCase(identifier))
                  {

                     // display error message to user to
                     // notify that demonstration identifier
                     // already exists
                     System.out.println("ERROR -> IDENTIFIER ALREADY EXISTS\n");

                     // set condition so do-while loop is
                     // not exited as new identifier needs
                     // to be entered
                     eventIdExists = true;

                     // break out of for loop as
                     // identifier was found
                     break;

                  }
                  // if identification does not exist set
                  else
                  {
                     // do-while exit condition
                     eventIdExists = false;
                  }

               }

            } while (eventIdExists); // loop while identification not unique

         }
         // no demonstrations added so no need to
         // cycle through non existing events
         else
         {

            // check that input is valid
            boolean eventIDLengthZero = true;
            do
            {

               // get user to enter event identification
               System.out.print("ENTER -> Event Identifier: ");
               identifier = sc.nextLine().toLowerCase();

               // if identifier length is greater
               // than 0 continue, else ask for
               // new identifier
               if (identifier.length() > 0)
               {

                  // user selected exit
                  if (identifier.matches("x"))
                  {
                     return;
                  }
                  else if (identifier.startsWith("d") || identifier.startsWith("w"))
                  {

                     // exit do-while loop as all
                     // details are good
                     eventIDLengthZero = false;
                  }
                  // user entered valid identifier string
                  // and not x for exit
                  else
                  {
                     System.out
                              .println("ERROR -> IDENTIFIER MUST START WITH D OR W\n");

                  }

               }
               // user has not entered a valid input
               else
               {
                  // show user an error message
                  System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
               }

            } while (eventIDLengthZero); // until valid identifier
                                         // has been entered
         }

         // ADD TITLE
         //
         // if more than one demonstration has been created
         // checks to see if title entered by user has
         // been previously used, if no demonstrations have
         // previously created excepts the first one entered
         //
         // @param: demonstrationCounter -> integer ----> Number of demonstrations
         // @param: title ----------------> Scanner in -> Demonstration title
         // @param: answer ---------------> Scanner in -> gets y or n from user
         // @param: titleExist -----------> boolean ----> While title exists loop
         // @param: eventTitleLengthZero -> boolean ----> While input length = 0
         // ..............................................and identifier does not
         // ..............................................start with d or w.
         // @param: identifier -----------> String -----> Scanner input from user
         // @Object: demonstrations[i] ---> Array ------> Stores demonstrations

         // initialize variable
         String title = null;

         if (demonstrationCounter > 0)
         {
            // set do/while exit condition
            boolean titleExists = true;
            do
            {
               // get user to enter event title
               System.out.print("ENTER -> Event Title: ");
               title = sc.nextLine().toLowerCase();

               // cycle through events checking for
               // any matching event titles
               for (int i = 0; i < demonstrationCounter; i++)
               {
                  // demonstration title number is not
                  // unique and has matched one stored in array
                  if (demonstrations[i].getTitle().equalsIgnoreCase(title))
                  {

                     // display error message to user to
                     // notify that demonstration title
                     // already exists
                     System.out.println("ERROR -> TITLE ALREADY EXISTS\n");

                     // check input is either character
                     // y or n, else loop until correct
                     // input has been entered
                     String answer = "";
                     do
                     {
                        // ask user if they wish to keep the
                        // current title or make a new title
                        // that has not been previously used
                        System.out.print("Do you wish to use this tile (Y/N)? ");
                        answer = sc.nextLine().toLowerCase();

                        // user wants to use title even though
                        // it is not unique.
                        if (answer.matches("y"))
                        {
                           // set condition so do-while loop is
                           // exited as user wants to keep title
                           // even though not unique
                           titleExists = false;

                           // break out of for loop as
                           // title was found
                           break;
                        }
                        // user wants to reject current entered
                        // title and wants to enter a new one
                        else if (answer.matches("n"))
                        {
                           // set condition so do-while loop is
                           // not exited as new title needs
                           // to be entered
                           titleExists = true;

                           // break out of for loop as
                           // title was found
                           break;
                        }
                        else
                        {
                           // user has not entered y or n
                           // ask user provide correct input
                           System.out
                                    .println("ERROR -> PLEASE ENTER A VALID INPUT\n");
                        }

                     } while (!answer.matches("[yn]"));

                  }
                  else
                  {
                     // if title does not exist set
                     // do-while exit condition
                     titleExists = false;
                  }

               }

            } while (titleExists); // loop while title not unique
                                   // or user does not want to use
                                   // the same title again.

         }
         // no demonstrations added so no need to
         // cycle through non existing events
         else
         {
            // check that input is valid
            boolean eventTitleLengthZero = true;
            do
            {

               // get user to enter event title
               System.out.print("ENTER -> Event Title: ");
               title = sc.nextLine().toLowerCase();

               // if title length is greater
               // than 0 continue, else ask for
               // new title
               if (title.length() > 0)
               {

                  // user selected exit
                  if (title.matches("x"))
                  {
                     return;
                  }

                  // user entered valid title string
                  // and not x for exit
                  else
                  {
                     // exit do-while loop as all
                     // details are good
                     eventTitleLengthZero = false;
                  }

               }
               else
               {
                  // user has not entered a valid input
                  // show user an error message
                  System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
               }

            } while (eventTitleLengthZero); // until valid title
                                            // has been entered

         }

         // ADD BASE FEE
         //
         // gets base fee input from user
         // takes input as String variable feeIn
         // tests if it is decimal value greater than 0
         //
         // @param: feeIn -----------> Scanner in -> Demonstration base fee
         // @param: feeInLengthZero -> boolean ----> While input length = 0
         // @param: baseFee ---------> double -----> Event standard cost
         // @param: integerValue ----> integer ----> do while input not integer

         // set variables and conditions
         String feeIn = null;
         double baseFee = 0;

         // set do while condition variable
         boolean integerValue = false;
         do
         {

            // check that input is valid
            boolean feeInLengthZero = true;
            do
            {

               // get user to enter event base fee
               System.out.print("ENTER -> Event Base Fee: ");
               feeIn = sc.nextLine().toLowerCase();

               // if base fee length is greater
               // than 0 continue, else ask for
               // new input
               if (feeIn.length() > 0)
               {

                  // user selected exit
                  if (feeIn.matches("x"))
                  {
                     // return to main menu
                     return;
                  }

                  // user entered valid base fee string
                  // and not x for exit
                  else
                  {
                     // exit do-while loop as all
                     // details are good
                     feeInLengthZero = false;
                  }

               }
               // user has not entered a valid input
               else
               {
                  // show user an error message
                  System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
               }

            } while (feeInLengthZero); // until valid base fee
                                       // has been entered

            // test for number value
            if (feeIn.matches("[0-9.]+"))
            {
               // convert to number value
               baseFee = Double.parseDouble(feeIn);

               // test for number value greater than 0
               if (baseFee > 0)
               {
                  // exit do while loop
                  integerValue = true;
               }
               // input not in required range
               else
               {
                  System.out
                           .println("ERROR -> PLEASE ENTER NUMBER GREATER THAN 0\n");
               }
            }
            // not numeric input
            else
            {
               System.out.println("ERROR -> PLEASE ENTER NUMBER GREATER THAN 0\n");
            }

         } while (!integerValue);

         // ADD MAX ATTENDEES
         //
         // gets max attendees input from user
         // takes input as String variable maxAttendIn
         // parses input to decimal value and
         // tests if it is decimal value greater than 0
         //
         // @param: maxAttendIn -----------> Scanner in -> Demonstration maximum
         // ...............................................attendees allowed
         // @param: maxAttendInLengthZero -> boolean ----> While input length = 0
         // @param: maxAttendees ----------> parseInt ---> Convert string to integer
         // @param: integerValue ----------> integer ----> do while input not integer

         // set variables and conditions
         int maxAttendees = 0;
         String maxAttendIn = null;
         // set do while condition variable
         integerValue = false;
         do
         {

            // check that input is valid
            boolean maxAttendInLengthZero = true;
            do
            {

               // get user to enter event base fee
               System.out
                        .print("ENTER -> Event Maximum Attendees: ");
               maxAttendIn = sc.nextLine().toLowerCase();

               // if base fee length is greater
               // than 0 continue, else ask for
               // new input
               if (maxAttendIn.length() > 0)
               {

                  // user selected exit
                  if (maxAttendIn.matches("x"))
                  {
                     return;
                  }

                  // user entered valid base fee string
                  // and not x for exit
                  else
                  {
                     // exit do-while loop as all
                     // details are good
                     maxAttendInLengthZero = false;
                  }

               }
               else
               {
                  // user has not entered a valid input
                  // show user an error message
                  System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
               }

            } while (maxAttendInLengthZero); // until valid base fee
                                             // has been entered

            // test for number value
            if (maxAttendIn.matches("[0-9]+"))
            {
               // convert to number value
               maxAttendees = Integer.parseInt(maxAttendIn);

               // test for number value greater than 0
               if (maxAttendees > 0)
               {
                  // exit do while loop
                  integerValue = true;
               }
               // input not in required range
               else
               {
                  System.out.println("ERROR -> PLEASE ENTER VALUE GREATER THAN 0\n");
               }
               // not numeric input
            }
            else
            {
               System.out.println("ERROR -> PLEASE ENTER VALUE GREATER THAN 0\n");
            }
         } while (!integerValue);

         // ADD STARTING TIME
         //
         // gets starting time input from user
         // takes input as String variable mstartIn
         // parses input to decimal value and
         // tests if it is decimal between 0 and 24
         //
         // @param: startIn -----------> Scanner in -> Demonstration start time
         // @param: startTime----------> ParseInt ---> Convert string to integer
         // @param: startInLengthZero -> boolean ----> While length = 0
         // @param: integerValue ------> boolean ----> do while loop exit condition

         // set variables and conditions
         int startingTime = 0;
         String startIn = null;
         // set do while condition variable
         integerValue = false;
         do
         {
            // check that input is valid
            boolean startInLengthZero = true;
            do
            {
               // get user to enter event base fee
               System.out
                        .print("ENTER -> Event Starting Time (0 - 24): ");
               startIn = sc.nextLine().toLowerCase();

               // if base fee length is greater
               // than 0 continue, else ask for
               // new input
               if (startIn.length() > 0)
               {

                  // user selected exit
                  if (startIn.matches("x"))
                  {
                     // return to main menu
                     return;
                  }

                  // user entered valid base fee string
                  // and not x for exit
                  else
                  {
                     // exit do-while loop as all
                     // details are good
                     startInLengthZero = false;
                  }

               }
               // user has not entered a valid input
               else
               {
                  // show user an error message
                  System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
               }

            } while (startInLengthZero); // until valid base fee
                                         // has been entered

            // test for number value
            if (startIn.matches("[0-9]+"))
            {
               // convert to number value
               startingTime = Integer.parseInt(startIn);

               // test for number value between 0 and 24
               if (startingTime >= 0 && startingTime <= 24)
               {
                  // exit do while loop
                  integerValue = true;
               }
               // input not in required range
               else
               {
                  System.out.println("ERROR -> PLEASE ENTER VALUE (0 - 24)\n");
               }
            }
            // not numeric input
            else
            {
               System.out.println("ERROR -> PLEASE ENTER VALUE (0 - 24)\n");
            }
         } while (!integerValue);

         // ADD DURATION
         //
         // gets duration time input from user
         // takes input as String variable durationIn
         // parses input to decimal value and
         // tests if it is decimal greater than 0
         //
         // @param: durationIn --------> Scanner in -> Demonstration duration
         // @param: duration ----------> ParseInt ---> Convert string to integer
         // @param: integerValue ------> boolean ----> do while loop exit condition
         // @param: durationInLengthZero -> boolean ----> While length = 0

         // set variables and conditions
         int duration = 0;
         String durationIn = null;
         // set do while condition variable
         integerValue = false;
         do
         {
            // check that input is valid
            boolean durationInLengthZero = true;
            do
            {
               // get user to enter event base fee
               System.out.print("ENTER -> Event Duration (Min): ");
               durationIn = sc.nextLine().toLowerCase();

               // if base fee length is greater
               // than 0 continue, else ask for
               // new input
               if (durationIn.length() > 0)
               {
                  // user selected exit
                  if (durationIn.matches("x"))
                  {
                     // return to main menu
                     return;
                  }
                  // user entered valid base fee string
                  // and not x for exit
                  else
                  {
                     // exit do-while loop as all
                     // details are good
                     durationInLengthZero = false;
                  }

               }
               else
               {
                  // user has not entered a valid input
                  // show user an error message
                  System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
               }

            } while (durationInLengthZero); // until valid base fee
            // has been entered

            // test for number value
            if (durationIn.matches("[0-9]+"))
            {
               // convert to number value
               duration = Integer.parseInt(durationIn);

               // test for number value greater than 0
               if (duration > 0 && duration <= 1440)
               {
                  // exit do while loop
                  integerValue = true;
               }
               // input not in required range
               else
               {
                  System.out
                           .println("ERROR -> PLEASE ENTER VALUE 1(1 Min) to 1440(24Hrs)\n");
               }
            }
            // not numeric input
            else
            {
               System.out.println("ERROR -> PLEASE ENTER VALUE GREATER THAN 0");
            }
         } while (!integerValue);

         // Create event instance
         demonstrations[demonstrationCounter] =
                  new Demonstration(identifier, title, baseFee,
                                    maxAttendees, startingTime, duration);

         // increment event counter after event created
         demonstrationCounter++;

         // display message to user
         System.out.println("\nINFORMATION -> Event Added Successfully\n");
      }
      else // Event Array full
      {
         System.out.println("ERROR -> MAXIMUM EVENTS CREATED");
      }

   }

   // OPTION 2 - ADD ATTENDEE TO DEMONSTRATION
   //
   // addDemonstration method gets user input
   // for required details
   //
   // @param: identifier ---> Event Identification number
   // @param: title --------> Event title
   // @param: baseFee ------> Event standard cost
   // @param: maxAttendees -> Event maximum attendees allowed
   // @param: startingTime -> Event start time (24hr) 0 - 24
   // @param: duration -----> Event length of demonstration (minutes)
   // @param: sc -----------> Scanner

   private static void addAttendee(Scanner sc)
   {

      // @param: cardOne ---> double -> gets value assigned
      // @param: cardTwo ---> double -> gets value assigned
      // @param: cardThree -> double -> gets value assigned
      // @param: cardFour --> double -> gets value assigned

      double cardOne = 0;
      double cardTwo = 0;
      double cardThree = 0;
      double cardFour = 0;
      double price = 0;

      // @param: CCH -------> double -> percentage discount
      // @param: FSRS ------> double -> percentage discount
      // @param: ARHS ------> double -> percentage discount
      // @param: MHR -------> double -> percentage discount

      final double CCH = 10;
      final double FSRS = 20;
      final double ARHS = 25;
      final double MHR = 100;

      // @param: card1 -----> Scanner In -> card type
      // @param: card2 -----> Scanner In -> card type
      // @param: card3 -----> Scanner In -> card type
      // @param: card4 -----> Scanner In -> card type

      String card1 = null;
      String card2 = null;
      String card3 = null;
      String card4 = null;

      // @param: name ------> Scanner In -> user input
      // @param: phone -----> Scanner In -> user input
      String name;
      String phone;

      // set variables and conditions
      int demoLocation = 0;
      int attendeeCount = 0;
      int cardsTotal = 0;

      // set do while condition variable
      boolean demonstrationFound = false;
      do
      {
         // get input from user
         System.out.print("\nENTER -> Demonstration ID: ");
         String demo = sc.nextLine().toLowerCase();

         if (demo.equals("x")) // exit selected
         {
            // return to main menu
            return;
         }
         // search for demonstration identification
         else
         {
            // search array for demonstration identification number
            for (int i = 0; i < demonstrationCounter; i++)
            {
               // if demonstration is found
               // assign location value to variable
               if (demonstrations[i].getIdentifier().equals(demo))
               {

                  // if demonstration not fully booked
                  if (demonstrations[i].getAttendeeCount() < demonstrations[i]
                           .getMaxAttendees())
                  {
                     // sets demonstration array value
                     demoLocation = i;
                     // demonstration identifier found
                     demonstrationFound = true;
                  }
                  // array full
                  else
                  {
                     System.out.println("ERROR -> DEMONSTRATION FULLY BOOKED\n");
                     // return to main menu
                     return;
                  }

               }
            }
         }

         // demonstration not found in array
         if (!demonstrationFound)
         {
            System.out.println("ERROR -> DEMONSTRATION NOT FOUND\n");
         }

      } while (!demonstrationFound);

      // do on second attendee input
      if (demonstrations[demoLocation].getAttendeeCount() > 0)
      {

         // set do while condition variable
         boolean detailsMatch = true;
         do
         {

            // get attendee name
            System.out.print("ENTER -> Attendee NAME: ");
            name = sc.nextLine();

            // user selected exit
            if (name.matches("x"))
            {
               // return to main menu
               return;
            }

            // get attendee phone
            System.out.print("ENTER -> Attendee PHONE: ");
            phone = sc.nextLine();

            // user selected exit
            if (phone.matches("x"))
            {
               // return to main menu
               return;
            }

            // gets attendee count and assigned to variable
            attendeeCount = demonstrations[demoLocation].getAttendeeCount();

            // loops through attendee amount
            for (int i = 0; i < attendeeCount; i++)
            {
               // gets stored name for test condition
               String storedName = demonstrations[demoLocation].getAttendeeName(i);
               // get stored phone for test condition
               String storedPhone = demonstrations[demoLocation].getAttendeePhone(i);

               // if details match raise error message
               if (name.equalsIgnoreCase(storedName) &&
                   phone.equals(storedPhone))
               {
                  System.out
                           .println("ERROR -> DETAILS ATTENDEE DETAILS ALREADY EXIST\n");
                  // exit for loop if details found
                  break;
               }
               // details not found on loop pass
               // set condition to false
               else
               {
                  detailsMatch = false;
               }

            }
            // loop while details match store details
         } while (detailsMatch);

      }
      else
      {
         // get attendee name
         System.out.print("ENTER -> Attendee NAME: ");
         name = sc.nextLine();

         // user selected exit
         if (name.matches("x"))
         {
            // return to main menu
            return;
         }

         // get attendee phone
         System.out.print("ENTER -> Attendee PHONE: ");
         phone = sc.nextLine();

         // user selected exit
         if (phone.matches("x"))
         {
            // return to main menu
            return;
         }
      }

      // check input is either character
      // y or n, else loop until correct
      // input has been entered
      String answer = "";

      boolean haveMemberCards = false;
      do
      {
         // ask user if they have concession or
         // members cards.

         System.out.print("\nQUESTION -> Concession or members cards(Y/N)? ");
         answer = sc.nextLine().toLowerCase();

         // set variable condition that attendee
         // does have members cards.
         if (answer.matches("y"))
         {
            haveMemberCards = true;
         }
         else if (answer.matches("n"))
         {
            // set variable condition that attendee
            // does not have members cards.
            haveMemberCards = false;
         }
         else
         {
            System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
         }

         // loop until y or n input
      } while (!answer.matches("[yn]"));

      // do if attendee has either a concession card or
      // has one of three members cards
      if (haveMemberCards)
      {
         // Display to assist user with input codes
         System.out.println();
         System.out
                  .println("|---------------------------------------------------------|");
         System.out
                  .println("| Code | Description                           | DISCOUNT |");
         System.out
                  .println("|---------------------------------------------------------|");
         System.out
                  .println("| CCH  | Concession Card                       |  10% Off |");
         System.out
                  .println("|---------------------------------------------------------|");
         System.out
                  .println("| FSRS | Feilding Steam Rail Society           |  20% Off |");
         System.out
                  .println("|---------------------------------------------------------|");
         System.out
                  .println("| ARHS | Australian Railway Historical Society |  25% Off |");
         System.out
                  .println("|---------------------------------------------------------|");
         System.out
                  .println("| MHR  | Moolort Heritage Railway              | 100% Off |");
         System.out
                  .println("|---------------------------------------------------------|");
         System.out.println();

         // set common error message
         String cardErrorMsg = "\nERROR - CARD NOT RECONIZED";
         // set do-while condition
         boolean UserWantsToEnterCards = true;
         do
         {
            // set card test condition
            boolean goodCard = true;

            // ask user to enter member cards
            System.out.printf("ENTER -> Card %d CODE: ", cardsTotal + 1);

            // assigns card values as they are
            // entered as input by user

            if (cardsTotal == 0)
            {
               // gets card one type from user
               card1 = sc.nextLine().toLowerCase();

               // if card1 = Concession Card
               if (card1.equals("cch"))
               {
                  // assigned value of 10
                  cardOne = CCH;
               }
               // if card1 = Fielding Steam Rail Society
               else if (card1.equals("fsrs"))
               {
                  // assigned value of 20
                  cardOne = FSRS;
               }
               // if card1 = Australian Railway Historical Society
               else if (card1.equals("arhs"))
               {
                  // assigned value of 25
                  cardOne = ARHS;
               }

               // if card1 = Moolort Heritage Railway
               else if (card1.equals("mhr"))
               {
                  // assigned value of 100
                  cardOne = MHR;
               }
               else
               { // card not recognized
                  cardOne = 0; // set default value
                  // set card condition, true if card recognized
                  goodCard = false;
                  System.out.println(cardErrorMsg);

               }
            }

            else if (cardsTotal == 1)
            {
               // gets card two type from user
               card2 = sc.nextLine().toLowerCase();

               // if card2 = Concession Card
               if (card2.equals("cch"))
               {
                  // assigned value of 10
                  cardTwo = CCH;
               }
               // if card2 = Fielding Steam Rail Society
               else if (card2.equals("fsrs"))
               {
                  // assigned value of 20
                  cardTwo = FSRS;
               }
               // if card2 = Australian Railway Historical Society
               else if (card2.equals("arhs"))
               {
                  // assigned value of 25
                  cardTwo = ARHS;
               }
               // if card2 = Moolort Heritage Railway
               else if (card2.equals("mhr"))
               {
                  // assigned value of 100
                  cardTwo = MHR;
               }
               else
               { // card not recognized
                  cardTwo = 0;
                  // set card condition, true if card recognized
                  goodCard = false;
                  System.out.println(cardErrorMsg);
               }
            }
            else if (cardsTotal == 2)
            {
               // gets card three type from user
               card3 = sc.nextLine().toLowerCase();

               // if card3 = Concession Card
               if (card3.equals("cch"))
               {
                  // assigned value of 10
                  cardThree = CCH;
               }
               // if card3 = Fielding Steam Rail Society
               else if (card3.equals("fsrs"))
               {
                  // assigned value of 20
                  cardThree = FSRS;
               }
               // if card3 = Australian Railway Historical Society
               else if (card3.equals("arhs"))
               {
                  // assigned value of 25
                  cardThree = ARHS;
               }
               // if card3 = Moolort Heritage Railway
               else if (card3.equals("mhr"))
               {
                  // assigned value of 100
                  cardThree = MHR;
               }
               else
               { // card not recognized
                  cardThree = 0;
                  // set card condition, true if card recognized
                  goodCard = false;
                  System.out.println(cardErrorMsg);
               }
            }
            else if (cardsTotal == 3)
            {
               // gets card four type from user
               card4 = sc.nextLine().toLowerCase();

               // if card4 = Concession Card
               if (card4.equals("cch"))
               {
                  // assigned value of 10
                  cardFour = CCH;
               }
               // if card4 = Fielding Steam Rail Society
               else if (card4.equals("fsrs"))
               {
                  // assigned value of 20
                  cardFour = FSRS;
               }
               // if card4 = Australian Railway Historical Society
               else if (card4.equals("arhs"))
               {
                  // assigned value of 25
                  cardFour = ARHS;
               }
               // if card4 = Moolort Heritage Railway
               else if (card4.equals("mhr"))
               {
                  // assigned value of 100
                  cardFour = MHR;
               }
               else
               { // card not recognized
                  cardFour = 0;
                  // set card condition, true if card recognized
                  goodCard = false;
                  System.out.println(cardErrorMsg);
               }
            }

            // card added - increment count if card recognized
            if (goodCard == true)
            {
               cardsTotal++;
            }

            if (cardsTotal < 4)
            {
               // ask user if they want to enter another card
               answer = "";
               do
               {
                  // ask user if they want to enter another card
                  System.out.println("QUESTION -> Enter another card(Y/N)");
                  answer = sc.nextLine();

                  // set variable condition that attendee
                  // wants to enter another members card.
                  if (answer.matches("y"))
                  {
                     UserWantsToEnterCards = true;
                  }
                  // set variable condition that attendee
                  // does not want to enter another member card.
                  else if (answer.matches("n"))
                  {
                     UserWantsToEnterCards = false;
                  }
                  else
                  {
                     System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
                  }

                  // loop until y or n input
               } while (!answer.matches("[yn]"));

            }
            else
            {
               // user does not want to enter more cards
               UserWantsToEnterCards = false;
            }

            // loop while user wants to enter cards
            // maximum recognized cards is 4
         } while (UserWantsToEnterCards);

      }

      // check number of cards entered and call correct
      // demonstration method for correct price
      //
      // if no card have been entered
      if (cardsTotal == 0)
      {
         // get event cost and assign to variable price
         price = demonstrations[demoLocation].getBaseFee();
      }
      // one card entered
      else if (cardsTotal == 1)
      {
         // get event cost and assign to variable price
         price = demonstrations[demoLocation].getCost(cardOne);
      }
      // two cards entered
      else if (cardsTotal == 2)
      {
         // get event cost and assign to variable price
         price = demonstrations[demoLocation].getCost(cardOne,
                                                      cardTwo);
      }
      // three cards entered
      else if (cardsTotal == 3)
      {
         // get event cost and assign to variable price
         price = demonstrations[demoLocation].getCost(cardOne,
                                                      cardTwo,
                                                      cardThree);
      }
      // four cards entered
      else if (cardsTotal == 4)
      {
         // get event cost and assign to variable price
         price = demonstrations[demoLocation].getCost(cardOne,
                                                      cardTwo,
                                                      cardThree,
                                                      cardFour);
      }

      // assign attendee to demonstration
      boolean booking = demonstrations[demoLocation].addAttendee(name,
                                                                 phone,
                                                                 price);

      // if booking was successful display on screen
      if (booking)
      {
         // display confirmation
         System.out.printf("\n-------------------------------------\n");
         System.out.printf("     ATTENDEE BOOKING SUCCESSFUL\n");
         System.out.printf("-------------------------------------\n");
         System.out.printf("Name : %s\n", name);
         System.out.printf("Phone: %s\n", phone);
         System.out.printf("-------------------------------------\n");
         System.out.printf("Cost : $%.2f\n", price);
         System.out.printf("-------------------------------------\n\n");
      }
      // if booking failed display message
      else
      {
         System.out.println("ERROR -> BOOKING FAILED\n");
      }

   }

   // OPTION 3 - VIEW ONE DEMONSTRATION
   //
   // @param: demoToSearchFor ------> String --> scanner input
   // @param: wantToViewDemo -------> boolean -> do-while condition
   // @param: demoFound ------------> boolean -> Demonstration found
   // @param: demonstrationCounter -> Integer -> Demonstration total
   // @param: demonstrations[] -----> Object --> Demonstration storage

   private static void viewOneDemonstration(Scanner sc)
   {
      // set do-while condition
      boolean wantToViewDemo = true;
      do
      {
         // sets default condition
         boolean demoFound = false;

         // ask user for demonstration identification
         System.out.print("\nENTER -> Demonstration ID: ");
         String demoToSearchFor = sc.nextLine().toLowerCase();

         // user has selected exit
         if (demoToSearchFor.equals("x"))
         {
            // return to main menu
            return;
         }
         // look for demonstration identifier
         else
         {
            // loop through demonstrations to see if a match
            for (int i = 0; i < demonstrationCounter; i++)
            {
               // match is found
               if (demonstrations[i].getIdentifier()
                        .equals(demoToSearchFor))
               {
                  // display demonstration information
                  demonstrations[i].displayEventInfo();
                  demoFound = true;
                  wantToViewDemo = false;
               }
            }
         }
         // demonstration not found
         if (!demoFound)
         {
            System.out.println("ERROR -> DEMONSTRATION NOT FOUND");
         }
         // loop while user wants to view demo
      } while (wantToViewDemo);

   }

   // OPTION 4 - VIEW ALL DEMONSTRATIONS
   //
   // @param: demonstrationCounter -> Integer -> Demonstration total
   // @param: demonstrations[] -----> Object --> Demonstration storage

   private static void viewAllDemonstrations()
   {
      // loop through demonstrations
      for (int i = 0; i < demonstrationCounter; i++)
      {
         // display all demonstrations
         demonstrations[i].displayEventInfo();
         System.out.println(); // add space
      }
      // no demonstrations exist
      if (demonstrationCounter == 0)
      {
         System.out.println("ERROR -> NO DEMONSTRATIONS HAVE BEEN ADDED\n");
      }
   }

   // VIEW STATISTICS
   //
   // @param: eventID --------------> String --> gets identifier
   // @param: maxAttendees ---------> Integer -> maximum attendees
   // @param: attendees ------------> Integer -> current attendees
   // @param: percentage -----------> Integer -> attendees / max attendees
   // @param: demonstrationCounter -> Integer -> Demonstration total
   // @param: demonstrations[] -----> Object --> Demonstration storage

   private static void viewStatistics()
   {
      // set variables
      int maxAttendees;
      int attendees;
      float percentage = 0;

      // display statistic information on screen
      System.out.println();
      System.out.println("-".repeat(56));
      System.out.println(" ".repeat(17) + "DEMONSTRATION STATISTICS");
      System.out.println("-".repeat(56));
      String sections = String.format("%-14s : %-14s: %-10s: %s\n", "IDENTIFIER",
                                      "MAX ATTENDEES", "ATTENDEES", "% BOOKED");
      System.out.print(sections);
      System.out.println("-".repeat(56));
      if (demonstrationCounter > 0)
      {
         // loop through demonstrations
         for (int i = 0; i < demonstrationCounter; i++)
         {
            // assign identifier to variable
            String eventID = demonstrations[i].getIdentifier();

            // do if attendees exists
            if (demonstrations[i].getAttendeeCount() > 0)
            {
               // get maximum attendees and assign top variable
               maxAttendees = demonstrations[i].getMaxAttendees();
               // get total attendee number and assign to variable
               attendees = demonstrations[i].getAttendeeCount();
               // calculate percentage for display
               percentage = ((float) attendees / (float) maxAttendees) * 100;
            }

            // set up display string
            String s = String
                     .format("%-14s : %-14d: %-10d: %.0f\n",
                             eventID, demonstrations[i].getMaxAttendees(),
                             demonstrations[i].getAttendeeCount(), percentage);

            // set percentage to 0 as default
            percentage = 0;
            // display string format on screen
            System.out.print(s);
            System.out.println("-".repeat(56));
         }
      }
      else
      {
         System.out.println("ERROR -> NO EVENTS OR NO ATTENDEES\n");
      }

   }

   // CANCEL A ATTENDEE
   //
   // @param: name ---------------------> String --> attendee name
   // @param: phone --------------------> String --> attendee phone number
   // @param: question -----------------> String --> Y or N to cancel
   // @param: demonstrationToSearchFor -> String --> demonstration input
   // @param: demoFound ----------------> boolean -> demonstration found
   // @param: nameAndPhoneFound --------> boolean -> both details match
   // @param: cancellationSuccessful ---> boolean -> cancellation went through
   // @param: wantToViewAttendee -------> boolean -> do-while condition
   // @param: demonstrationCounter -----> Integer -> Demonstration total
   // @param: demonstrations[] ---------> Object --> Demonstration storage

   private static void cancelAttendee(Scanner sc)
   {
      // set variable conditions
      boolean demoFound = false;
      boolean nameAndPhoneFound = false;
      boolean cancellationSuccessful = false;
      boolean wantTocancelAttendee = true;

      do
      {
         // get Identification number from user
         System.out.print("\nENTER -> Demonstration ID: ");
         String demonstrationToSearchFor = sc.nextLine().toLowerCase();

         // exit option chosen by user
         if (demonstrationToSearchFor.equals("x"))
         {
            // return to main menu
            return;
         }
         // continue to cancel attendee
         else
         {
            // loop through demonstrations
            for (int i = 0; i < demonstrationCounter; i++)
            {
               // demonstration identifier found
               if (demonstrations[i].getIdentifier()
                        .equals(demonstrationToSearchFor))
               {
                  // set found state
                  demoFound = true;
                  // set do-while state for exit
                  wantTocancelAttendee = false;

                  // get details of name and phone to delete
                  nameAndPhoneFound = false;
                  do
                  {

                     // ask user for attendee name to cancel
                     System.out.print("ENTER -> Attendee name: ");
                     String name = sc.nextLine();

                     // Exit option chosen by user
                     if (name.equals("x"))
                     {
                        // return to main menu
                        return;
                     }

                     // ask user for attendee phone to cancel
                     System.out.print("ENTER -> Attendee phone: ");
                     String phone = sc.nextLine();

                     // Exit option chosen by user
                     if (phone.equals("x"))
                     {
                        // return to main menu
                        return;
                     }

                     // check for name
                     for (int j = 0; j < demonstrations[i].getAttendeeCount(); j++)
                     {

                        // if name matches both name and phone
                        if (demonstrations[i].getAttendeeName(j)
                                 .equalsIgnoreCase(name) &&
                            demonstrations[i].getAttendeePhone(j)
                                     .equalsIgnoreCase(phone))
                        {

                           // ask user for confirmation
                           boolean question = false;
                           do
                           {
                              // display message asking user if they are sure to
                              // cancel
                              System.out.println("QUESTION -> Are you sure (Y/N): ");

                              // get user input
                              String answer = sc.nextLine().toLowerCase();

                              // yes delete
                              if (answer.matches("y"))
                              {
                                 // exit do while state
                                 question = false;

                              }
                              // no dont delete
                              else if (answer.matches("n"))
                              {
                                 // return to main menu
                                 return;
                              }
                              else
                              {
                                 System.out
                                          .println("ERROR -> PLEASE ENTER A VALID INPUT\n");
                              }

                              // loop if question not y or n or x
                           } while (question);

                           // cancel attendee
                           cancellationSuccessful =
                                    demonstrations[i].cancelAttendee(j);

                           // confirm cancellation was successful
                           if (cancellationSuccessful)
                           {
                              System.out
                                       .println("INFORMATION -> ATTENDEE CANCELLATION SUCCESSFUL");
                           }
                           else
                           {
                              System.out
                                       .println("INFORMATION -> ATTENDEE CANCELLATION FAILED");
                           }

                           // nameAndPhoneFound = true;
                           return;

                        }
                        // name and phone match not found
                        else
                        {
                           continue;
                        }

                     }
                     // details do not match both name and phone in data
                     if (!nameAndPhoneFound)
                     {
                        System.out
                                 .println("\nERROR - NAME NOT FOUND OR DETAILS INCORRECT\n");
                     }

                     // loop while details do not match
                     // and are not found
                  } while (!nameAndPhoneFound);

               }
            }
         }

         // display message as demonstration not found for
         // supplied identification entered
         if (!demoFound)
         {
            System.out.println("ERROR - DEMONSTRATION NOT FOUND\n");
         }

      } while (wantTocancelAttendee);

   }

   // CANCEL A DEMONSTRATION
   //
   // @param: demonstrationToSearchFor -> String --> demonstration input
   // @param: answer -------------------> String --> Y or N input
   // @param: question -----------------> boolean -> Y or N to do while loop
   // @param: demoFound ----------------> boolean -> demonstration found
   // @param: wantToCancelDemonstration-> boolean -> do-while loop condition
   // @param: demonstrationCounter -----> Integer -> Demonstration total
   // @param: demonstrations[] ---------> Object --> Demonstration storage

   private static void cancelDemonstration(Scanner sc)
   {

      boolean wantToCancelDemonstration = true;
      do
      {

         boolean demoFound = false;
         String error = "ERROR -> DEMONSTRATION NOT FOUND\n";

         // ask user for demonstration identification
         System.out.print("\nENTER -> Demonstration ID: ");
         String demonstrationToSearchFor = sc.nextLine().toLowerCase();

         // exit option chosen by user
         if (demonstrationToSearchFor.equals("x"))
         {
            return; // return to main menu
         }
         else
         {
            // ask user for confirmation
            boolean question = false;
            do
            {
               // display message asking user if they are sure to cancel
               System.out.println("QUESTION -> Are you sure (Y/N): ");
               String answer = sc.nextLine().toLowerCase();

               // test input
               if (answer.matches("y"))
               {
                  // yes cancel
                  question = false;
               }
               // dont cancel
               else if (answer.matches("n"))
               {
                  // return to main menu
                  return;
               }
               else
               {
                  System.out.println("ERROR -> PLEASE ENTER A VALID INPUT\n");
               }
               // loop until y or n or x input
            } while (question);

            // loop through demonstrations
            for (int i = 0; i < demonstrationCounter; i++)
            {
               // if demonstration identifier matches
               // supplied demonstration identifier
               // then start cancellation process
               if (demonstrations[i].getIdentifier()
                        .equals(demonstrationToSearchFor))
               {

                  // loop through demonstrations from found
                  // demonstration to end of array
                  for (; i < demonstrations.length - 1; i++)
                  {
                     // shift array elements left
                     demonstrations[i] = demonstrations[i + 1];
                  }
                  // delete array in counter
                  demonstrationCounter--;

                  // confirm cancellation was successful
                  System.out
                           .println("INFORMATION -> DEMONSTRATION CANCELLATION SUCCESSFUL");

                  // return to main menu
                  return;

               }
            }
         }
         // supplied demonstration identifier not found
         if (!demoFound)
         {
            System.out.println(error);
         }
         // loop while still want to cancel demonstration
      } while (wantToCancelDemonstration);

   }

}
