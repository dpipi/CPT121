package assignment_01_part_c;

/*
 * Train Travel Booking System Software collects user information for a train ticketing system which comprises of 
 * stations: Castlemaine", "Campbell", "Guildford", "Strangway", "Newstead" and "Moolort".
 * 
 */

import java.util.Scanner;

public class BookingSystem
{

   public static void main(String[] args)
   {

      // JUST FOR TEACHER
      //
      // option to display array contents in a
      // visual form after the receipt is printed
      //
      // @param - displayForTeacher
      //
      // true: array outputs displayed
      // false: array outputs not displayed
      //
      boolean displayForTeacher = false;

      // Create a random number for first receipt
      int receiptNumber = (int) (Math.random() * 100000);

      // [boarding, departing, class, adult, childeFree, ChildPaid];
      Object[] selection = new Object[6];

      // initialize arrays and array lengths [total train stops][total class seats]
      String[][] firstClassSeats = new String[5][48];
      String[][] standardClassSeats = new String[5][70];
      String[][] excursionClassSeats = new String[5][95];

      // create Class instances
      TrainService firstClass = new TrainService(firstClassSeats);
      TrainService standardClass = new TrainService(standardClassSeats);
      TrainService excursionClass = new TrainService(excursionClassSeats);
      BookingReceipt<?> receipt = new BookingReceipt<Object>(receiptNumber);

      // create main menu message
      String msg = "";
      msg = msg + "\nMoolort Heritage Railway\n";
      msg = msg + "------------------------\n";
      msg = msg + "1 - Ticket Booking\n";
      msg = msg + "2 - Ticket Availability\n";
      msg = msg + "X - Exit\n";
      msg = msg + "Choice:";

      // set input scanner
      Scanner input = new Scanner(System.in);

      // do until exit called
      boolean exit = false;
      do
      {
         System.out.print(msg); // display message for user
         String choice = input.next();// get user input

         switch (choice)
         {
            case "1": // Ticket Booking

               // stationDataOK calls stationMenu, gets boarding location and
               // departing location, receives true or false depent if all user input
               // is correct.
               //
               // @param: input ---------------> Scanner -> user input
               // @param: selection -----------> array -> stores use input
               // @param: stationDataOk -------> boolean True / False

               boolean stationDataOK = stationMenu(input, selection);

               if (stationDataOK == true) // No escape selected
               {

                  // calls ticketMenu - Menu gets input from user and stores data in
                  //
                  //
                  // @param: input ---------------> Scanner -> user input

                  // @Object[] selection ---------> array -> stores use input
                  //
                  // selection[0] -> boarding station
                  // selection[1] -> departing station
                  // selection[2] -> ticket travel class
                  // selection[3] -> number of adult tickets
                  // selection[4] -> number of child paid tickets
                  // selection[5] -> number of child free tickets

                  // @param: firstClassSeats -----> array -> stores seats booked
                  // @param: standardClassSeats --> array -> stores seats booked
                  // @param: excursionClassSeats -> array -> stores seats booked
                  // @param: ticketDataOK -------> boolean True / False

                  boolean ticketDataOK = ticketMenu(input, selection, firstClass,
                                                    standardClass, excursionClass);

                  if (ticketDataOK == true)// No escape selected
                  {

                     // @Object[] selection ----------> array -> stores use input
                     // @Object[] firstClassSeats ----> array -> stores seats booked
                     // @Object[] standardClassSeats -> array -> stores seats booked
                     // @Object[] excursionClassSeats-> array -> stores seats booked
                     // @param: receiptNumber --------> instance of BookingReceipt
                     // @param: firstClass -----------> instance of TrainService
                     // @param: standardClass --------> instance of TrainService
                     // @param: excursionClass -------> instance of TrainService
                     // @param: receipt --------------> String --> receipt Number
                     // @param: displayForTeacher ----> boolean -> on/off
                     // @param: input ----------------> Scanner -> user input

                     receiptNumber =
                              ticketBooking(selection, firstClassSeats,
                                            standardClassSeats,
                                            excursionClassSeats, receiptNumber,
                                            firstClass, standardClass,
                                            excursionClass,
                                            receipt, displayForTeacher, input);
                  }
               }
               break;

            case "2": // Ticket Availability
               // calls method Availability - availablility method is a basic GUI
               // gets information from TrainService class.
               //
               // @param: Availability --------> Method call
               // @param: firstClass ----------> instance of TrainService
               // @param: standardClass -------> instance of TrainService
               // @param: excursionClass ------> instance of TrainService

               Availability(firstClass, standardClass, excursionClass);
               break;

            case "x": // Exit (Return to Main menu)
            case "X": // Exit (Return to Main menu)
               // close scanner on exit
               input.close();
               // set state for exit program
               exit = true;
               break;

            default: // input outside cases
               System.out.println("Error - Incorrect Choice!");
               break;
         }

      } while (exit == false);

      // exit program message
      System.out.println("Goodbye!");
   }

   public static boolean stationMenu(Scanner input, Object[] selection)
   {
      //
      // Gets boarding and departure station information
      // sets array data positons 0 and 1
      //
      // @param board - boarding station
      //
      // "Castlemaine"--> sets value 0 -> selection[0] array
      // "Campbell"-----> sets value 1 -> selection[0] array
      // "Guildford"----> sets value 2 -> selection[0] array
      // "Strangway"----> sets value 3 -> selection[0] array
      // "Newstead"-----> sets value 4 -> selection[0] array
      // "Moolort"------> sets value 5 -> selection[0] array
      //
      // @param depart - departing station
      //
      // "Castlemaine"--> sets value 0 -> selection[1] array
      // "Campbell"-----> sets value 1 -> selection[1] array
      // "Guildford"----> sets value 2 -> selection[1] array
      // "Strangway"----> sets value 3 -> selection[1] array
      // "Newstead"-----> sets value 4 -> selection[1] array
      // "Moolort"------> sets value 5 -> selection[1] array
      //
      //

      // set up boarding menu message
      String msg1 = "\nMoolort Heritage Railway\n";
      msg1 = msg1 + "------------------------\n";
      msg1 = msg1 + "0 - Castlemaine\n";
      msg1 = msg1 + "1 - Campbell\n";
      msg1 = msg1 + "2 - Guildford\n";
      msg1 = msg1 + "3 - Strangway\n";
      msg1 = msg1 + "4 - Newstead\n";
      msg1 = msg1 + "X - Main menu\n";

      // do until boarding information correct or exit called
      String board;
      boolean boardInfoOK = false;
      do
      {

         // display message station options
         System.out.print(msg1);

         // display message boarding station
         System.out.print("Enter boarding station: ");

         // take user input
         board = input.next();

         // test boarding input choice
         switch (board)
         {
            case "0": // Castlemaine
               selection[0] = 0; // assign to array selection
               boardInfoOK = true; // selection good
               break;

            case "1": // Campbell
               selection[0] = 1; // assign to array selection
               boardInfoOK = true; // selection good
               break;

            case "2": // Guildford
               selection[0] = 2; // assign to array selection
               boardInfoOK = true; // selection good
               break;

            case "3": // Strangway
               selection[0] = 3; // assign to array selection
               boardInfoOK = true; // selection good
               break;

            case "4": // Newstead
               selection[0] = 4; // assign to array selection
               boardInfoOK = true; // selection good
               break;

            case "x": // Return to Main menu
            case "X": // Return to Main menu
               return false;

            default:
               System.out.println("Error - Incorrect Choice!");
               break;
         }

      } while (boardInfoOK == false);

      // set up departing menu message
      String msg2 = "\nMoolort Heritage Railway\n";
      msg2 = msg2 + "------------------------\n";
      msg2 = msg2 + "0 - Castlemaine\n";
      msg2 = msg2 + "1 - Campbell\n";
      msg2 = msg2 + "2 - Guildford\n";
      msg2 = msg2 + "3 - Strangway\n";
      msg2 = msg2 + "4 - Newstead\n";
      msg2 = msg2 + "5 - Moolort\n";
      msg2 = msg2 + "X - Main menu\n";

      // do until departure information correct or exit called
      boolean departInputOK = false;
      do
      {

         // display message station options
         System.out.print(msg2);

         // display message departing station
         System.out.print("Enter departing station: ");

         // take user input
         String depart = input.next();

         switch (depart)
         {
            case "0": // Castlemaine
               selection[1] = 0;
               departInputOK = true;
               break;
            case "1": // Campbell
               selection[1] = 1;
               departInputOK = true;
               break;
            case "2": // Guildford
               selection[1] = 2;
               departInputOK = true;
               break;
            case "3": // Strangway
               selection[1] = 3;
               departInputOK = true;
               break;
            case "4": // Newstead
               selection[1] = 4;
               departInputOK = true;
               break;
            case "5": // Moolort
               selection[1] = 5;
               departInputOK = true;
               break;
            case "x": // Return to Main menu
            case "X": // Return to Main menu
               return false;
            default:
               System.out.println("Error - Incorrect Choice!");
               break;
         }

         // Test departing station follows boarding station
         // stops booking revers direction
         if (Integer.parseInt(depart) <= Integer.parseInt(board))
         {
            System.out.println("ERROR - INCORRECT INPUT");
            System.out.println("STATION MUST BE AFTER BOARDING STATION\n");
            departInputOK = false; // re-ask user to input choice
         }

      } while (departInputOK == false); // until boarding and departing information
                                        // is good

      return true; // boarding and departing information good

   }

   public static boolean ticketMenu(Scanner input, Object[] selection,
                                    TrainService firstClass,
                                    TrainService standardClass,
                                    TrainService excursionClass)
   {
      // Gets details from User via Scanner input
      // Saves options in Object[] selection
      //
      // @Object[] selection ---------> array -> stores use input
      //
      // selection[0] -> boarding station
      // selection[1] -> departing station
      // selection[2] -> ticket travel class
      // selection[3] -> number of adult tickets
      // selection[4] -> number of child paid tickets
      // selection[5] -> number of child free tickets
      //
      // @param: firstClass ----------> instance of TrainService
      // @param: standardClass -------> instance of TrainService
      // @param: excursionClass ------> instance of TrainService
      //
      // @param adultTickets ---------> total tickets
      // @param childPaidTickets -----> total tickets
      // @param childFreeTickets -----> total tickets
      //

      // create seat class menu message
      String msg = "";
      msg = msg + "\nMoolort Heritage Railway\n";
      msg = msg + "------------------------\n";
      msg = msg + "1 - First Class\n";
      msg = msg + "2 - Standard Class\n";
      msg = msg + "3 - Excursion Class\n";
      msg = msg + "X - Main Menu\n";
      msg = msg + "Choice:";

      boolean classInputOK = false;
      do
      {

         boolean abort = false;

         // initialize ticket variables
         int adultTickets = 0;
         int childPaidTickets = 0;
         int childFreeTickets = 0;

         System.out.println(msg);// display message for user
         String classType = input.next();

         switch (classType)
         {

            // Switch statement checks class type, assigns detail to array selection.
            // depending on selection gets further details:
            // ticket amounts: adult total, child(3-17) , child(under 3)

            case "1": // FIRST CLASS SELECTED

               // Case 1 - User has selected First Class Seating
               //
               // @Object[] selection ---------> array -> stores use input
               //
               // selection[0] -> boarding station
               // selection[1] -> departing station
               // selection[2] -> ticket travel class
               // selection[3] -> number of adult tickets
               // selection[4] -> number of child paid tickets
               // selection[5] -> number of child free tickets
               //
               // @param: tickets --------------> Scanner -> total adult tickets
               // @param: adultTickets ---------> total adult tickets
               // @param: childPaidTickets -----> total child tickets paid
               // @param: childFreeTickets -----> total child tickets free
               // @param: adultInputOK ---------> all details correct - true/false
               // @param: okToBook -------------> all details correct - true/false
               // @param: isIntValue -----------> all value int or x -- true/false
               // @param: abort ----------------> Abort to main menu

               selection[2] = "First Class"; // assign seat class to array
               boolean okToBook = false; // all details ok to book tickets
               boolean adultInputOK = false; // adult ticket information test

               while (adultInputOK == false) // while information incorrect
               {

                  boolean isIntValue = false; // test for integer value condition

                  do
                  {
                     // display message to enter adult ticket amount
                     System.out.print("Enter adult ticket amount: ");

                     // get adult ticket amount input from user
                     String tickets = input.next();

                     // test if number is a number value
                     if (tickets.matches("[0-9]+"))
                     {

                        // if number type convert to integer
                        // assign to new variable adultTickets
                        adultTickets = Integer.parseInt(tickets);

                        isIntValue = true; // is correct input
                     }

                     // test if 'x' or 'X' has been selected for abort
                     else if (tickets.matches("x") || tickets.matches("X"))
                     {
                        adultTickets = 0; // set zero on abort
                        isIntValue = true; // is correct input
                     }

                     else // input entered not number, x or X
                     {
                        System.out.println("ERROR - INVALID INPUT\n");
                        isIntValue = false; // not a correct input
                     }

                  } while (isIntValue == false); // until correct input

                  // selection[0] -> boarding station
                  // selection[1] -> departing station

                  // loop through array stops testing for enough seats
                  for (int row = (int) selection[0]; row < (int) selection[1]; row++)
                  {

                     // test seats available
                     if (adultTickets <= firstClass.checkSeatAmount(row))
                     {
                        okToBook = true; // All details ok to book tickets
                     }
                     else // All details not ok
                     {
                        // display ticket availability menu
                        Availability(firstClass, standardClass, excursionClass);

                        // display error message
                        System.out
                                 .println("ERROR - TOTAL GREATER THAN AVAILABLE SEATS");
                        System.out
                                 .println("ENTER NEW AMOUNT OR X TO RETURN TO MENU\n");
                        break;
                     }
                  }

                  if (okToBook == true) // All details ok to book tickets
                  {
                     adultInputOK = true; // information ok
                     selection[3] = adultTickets; // number of adult tickets
                  }
                  else
                  {
                     adultInputOK = false; // information not ok
                  }
               }
               break; // return from case

            case "2": // STANDARD CLASS SELECTED

               // Case 2 - User has selected Standard Class Seating
               //
               // @Object[] selection ---------> array -> stores use input
               //
               // selection[0] -> boarding station
               // selection[1] -> departing station
               // selection[2] -> ticket travel class
               // selection[3] -> number of adult tickets
               // selection[4] -> number of child paid tickets
               // selection[5] -> number of child free tickets
               //
               // @param: tickets --------------> Scanner -> total adult tickets
               // @param: adultTickets ---------> total adult tickets
               // @param: childPaidTickets -----> total child tickets paid
               // @param: childFreeTickets -----> total child tickets free
               // @param: adultInputOK ---------> all details correct - true/false
               // @param: okToBook -------------> all details correct - true/false
               // @param: isIntValue -----------> all value int or x -- true/false
               // @param: abort ----------------> Abort to main menu

               selection[2] = "Standard Class"; // assign seat class to array

               adultTickets = 0; // total adult tickets
               adultInputOK = false; // all input ok test
               okToBook = false; // all details ok to book tickets

               while (adultInputOK == false) // while information incorrect
               {

                  // test for integer value or x or X
                  boolean isIntValue = false;
                  do
                  {
                     // Take user input for ticket amount
                     System.out.print("Enter adult ticket amount: ");
                     String tickets = input.next();

                     // test if number is a number value
                     if (tickets.matches("[0-9]+"))
                     {
                        // if number type convert to integer
                        // assign to new variable adultTickets
                        adultTickets = Integer.parseInt(tickets);
                        isIntValue = true; // is correct input
                     }

                     // test if 'x' or 'X' has been selected for abort
                     else if (tickets.matches("x") || tickets.matches("X"))
                     {
                        abort = true; // abort selected
                        isIntValue = true; // exit loop
                        okToBook = false; // dont book tickets

                        // Set ticket numbers to 0
                        childPaidTickets = 0;
                        childFreeTickets = 0;
                        adultTickets = 0;

                     }
                     else // input entered not number, x or X
                     {
                        System.out.println("ERROR - INVALID INPUT\n");
                        isIntValue = false;
                     }
                  } while (isIntValue == false); // until correct input

                  // selection[0] -> boarding station
                  // selection[1] -> departing station

                  for (int row = (int) selection[0]; row < (int) selection[1]; row++)
                  {
                     if (adultTickets <= standardClass.checkSeatAmount(row))
                     {
                        okToBook = true;// All details ok to book tickets
                     }
                     else // All details not ok
                     {
                        // display ticket availability menu
                        Availability(firstClass, standardClass, excursionClass);

                        // display error message
                        System.out
                                 .println("ERROR - TOTAL GREATER THAN AVAILABLE SEATS");
                        System.out
                                 .println("ENTER NEW AMOUNT OR X TO RETURN TO MENU\n");
                        break;

                     }
                  }
                  if (okToBook == true)// All details ok to book tickets
                  {
                     adultInputOK = true; // information ok
                     selection[3] = adultTickets; // number of adult tickets
                  }
                  else
                  {
                     adultInputOK = false;// information not ok
                  }
               }

               // if abort not selected get child ticket information
               if (abort == false)
               {

                  // define variables and conditions
                  childPaidTickets = 0;
                  okToBook = false;
                  boolean childPaidInputOK = false;

                  // do until childPaidTicket information is correct
                  while (childPaidInputOK == false)
                  {

                     // test for integer value
                     boolean isIntValue = false;

                     do
                     {
                        // Take user input for ticket amount
                        System.out.print("Enter Child ticket amount(3 -> 17): ");
                        String tickets = input.next();

                        // test if number is a number value
                        if (tickets.matches("[0-9]+"))
                        {

                           // if number type convert to integer
                           // assign to new variable adultTickets
                           childPaidTickets = Integer.parseInt(tickets);
                           isIntValue = true; // is correct input
                        }

                        // test if 'x' or 'X' has been selected for abort
                        else if (tickets.matches("x") || tickets.matches("X"))
                        {
                           abort = true; // abort selected
                           isIntValue = true; // exit loop
                           okToBook = false; // dont book tickets

                           // Set ticket numbers to 0
                           childPaidTickets = 0;
                           childFreeTickets = 0;
                           adultTickets = 0;

                        }
                        else // input entered not number, x or X
                        {
                           System.out.println("ERROR - INVALID INPUT\n");
                           isIntValue = false;
                        }

                     } while (isIntValue == false); // until correct input

                     // selection[0] -> boarding station
                     // selection[1] -> departing station

                     for (int row =
                              (int) selection[0]; row < (int) selection[1]; row++)
                     {

                        if (childPaidTickets + adultTickets <= standardClass
                                 .checkSeatAmount(row))
                        {
                           okToBook = true;// All details ok to book tickets
                        }
                        else
                        {
                           // display ticket availability menu
                           Availability(firstClass, standardClass, excursionClass);

                           // display error message
                           System.out
                                    .println("ERROR - TOTAL GREATER THAN AVAILABLE SEATS");
                           System.out
                                    .println("ENTER NEW AMOUNT OR X TO RETURN TO MENU\n");
                           break;
                        }
                     }

                     if (okToBook == true) // All details ok to book tickets
                     {
                        childPaidInputOK = true; // information ok

                        // selection[4] -> number of child paid tickets
                        selection[4] = childPaidTickets;
                     }
                     else
                     {
                        childPaidInputOK = false;// information not ok
                     }

                  }
               }

               // if abort not selected get child ticket information
               if (abort == false)
               {

                  // loop if ticket information is incorrect
                  // else set adultInputOK to true for exit
                  childFreeTickets = 0;
                  okToBook = false;
                  boolean childInputOK = false;

                  while (childInputOK == false)
                  {

                     // test for integer value
                     boolean isIntValue = false;

                     do
                     {
                        // Take user input for ticket amount
                        System.out.print("Enter Child ticket amount(0 -> 2): ");
                        String tickets = input.next();

                        // test if number is a number value
                        if (tickets.matches("[0-9]+"))
                        {
                           // if number type convert to integer
                           // assign to new variable adultTickets
                           childFreeTickets = Integer.parseInt(tickets);
                           isIntValue = true; // Is an integer
                        }
                        else if (tickets.matches("x") || tickets.matches("X"))
                        {
                           abort = true; // abort selected
                           isIntValue = true; // exit loop
                           okToBook = false; // dont book tickets

                           // Set ticket numbers to 0
                           childPaidTickets = 0;
                           childFreeTickets = 0;
                           adultTickets = 0;

                        }
                        else // input entered not number, x or X
                        {
                           System.out.println("ERROR - INVALID INPUT\n");
                           isIntValue = false;
                        }

                     } while (isIntValue == false); // until correct input

                     // selection[0] -> boarding station
                     // selection[1] -> departing station

                     // loop through array stops testing for enough seats
                     for (int row =
                              (int) selection[0]; row < (int) selection[1]; row++)
                     {
                        // test seats available
                        if (childFreeTickets + childPaidTickets +

                            adultTickets <= standardClass.checkSeatAmount(row))
                        {
                           okToBook = true;// All details not ok
                        }
                        else
                        {
                           // display ticket availability menu
                           Availability(firstClass, standardClass, excursionClass);

                           // display error message
                           System.out
                                    .println("ERROR - TOTAL GREATER THAN AVAILABLE SEATS");
                           System.out
                                    .println("ENTER NEW AMOUNT OR X TO RETURN TO MENU\n");
                           break;

                        }

                     }

                     if (okToBook == true) // All details ok to book tickets
                     {
                        childInputOK = true;

                        // selection[5] -> number of child free tickets
                        selection[5] = childFreeTickets;
                     }
                     else
                     {
                        childInputOK = false; // information not ok
                     }
                  }
               }

               break; // return from case

            case "3": // EXCURSION CLASS

               // Case 3 - User has selected excursion Class Seating
               //
               // @Object[] selection ---------> array -> stores use input
               //
               // selection[0] -> boarding station
               // selection[1] -> departing station
               // selection[2] -> ticket travel class
               // selection[3] -> number of adult tickets
               // selection[4] -> number of child paid tickets
               // selection[5] -> number of child free tickets
               //
               // @param: tickets --------------> Scanner -> total adult tickets
               // @param: adultTickets ---------> total adult tickets
               // @param: childPaidTickets -----> total child tickets paid
               // @param: childFreeTickets -----> total child tickets free
               // @param: adultInputOK ---------> all details correct - true/false
               // @param: okToBook -------------> all details correct - true/false
               // @param: isIntValue -----------> all value int or x -- true/false
               // @param: abort ----------------> Abort to main menu

               selection[2] = "Excursion Class"; // assign seat class to array

               adultTickets = 0; // total adult tickets
               adultInputOK = false; // all input ok test
               okToBook = false; // all details ok to book tickets

               while (adultInputOK == false) // while information incorrect
               {
                  // test for integer value or x or X
                  boolean isIntValue = false;
                  do
                  {
                     // Take user input for ticket amount
                     System.out.print("Enter adult ticket amount: ");
                     String tickets = input.next();

                     // test if number is a number value
                     if (tickets.matches("[0-9]+"))
                     {
                        // if number type convert to integer
                        // assign to new variable adultTickets
                        adultTickets = Integer.parseInt(tickets);
                        isIntValue = true; // is correct input
                     }

                     // test if 'x' or 'X' has been selected for abort
                     else if (tickets.matches("x") || tickets.matches("X"))
                     {

                        abort = true; // abort selected
                        isIntValue = true; // exit loop
                        okToBook = false; // dont book tickets

                        // Set ticket numbers to 0
                        childPaidTickets = 0;
                        childFreeTickets = 0;
                        adultTickets = 0;

                     }
                     else // input entered not number, x or X
                     {
                        System.out.println("ERROR - INVALID INPUT\n");
                        isIntValue = false; // not a correct input
                     }

                  } while (isIntValue == false); // until correct input

                  // selection[0] -> boarding station
                  // selection[1] -> departing station
                  for (int row = (int) selection[0]; row < (int) selection[1]; row++)
                  {
                     if (adultTickets <= excursionClass.checkSeatAmount(row))
                     {
                        okToBook = true; // All details ok to book tickets
                     }
                     else // All details not ok
                     {
                        // display ticket availability menu
                        Availability(firstClass, standardClass, excursionClass);

                        // display error message
                        System.out
                                 .println("ERROR - TOTAL GREATER THAN AVAILABLE SEATS");
                        System.out
                                 .println("ENTER NEW AMOUNT OR X TO RETURN TO MENU\n");
                        break;
                     }
                  }

                  if (okToBook == true)// All details ok to book tickets
                  {
                     adultInputOK = true; // information ok
                     selection[3] = adultTickets; // number of adult tickets
                  }
                  else
                  {
                     adultInputOK = false;// information not ok
                  }
               }

               // if abort not selected get child ticket information
               if (abort == false)
               {

                  // define variables and conditions
                  childPaidTickets = 0;
                  okToBook = false;
                  boolean childPaidInputOK = false;

                  // do until childPaidTicket information is correct
                  while (childPaidInputOK == false)
                  {

                     // test for integer value
                     boolean isIntValue = false;
                     do
                     {
                        // Take user input for ticket amount
                        System.out.print("Enter Child ticket amount(3 -> 17): ");
                        String tickets = input.next();

                        // test if number is a number value
                        if (tickets.matches("[0-9]+"))
                        {

                           // if number type convert to integer
                           // assign to new variable adultTickets
                           childPaidTickets = Integer.parseInt(tickets);
                           isIntValue = true; // Is an integer
                        }

                        // test if 'x' or 'X' has been selected for abort
                        else if (tickets.matches("x") || tickets.matches("X"))
                        {
                           abort = true; // abort selected
                           isIntValue = true; // exit loop
                           okToBook = false; // dont book tickets

                           // Set ticket numbers to 0
                           childPaidTickets = 0;
                           childFreeTickets = 0;
                           adultTickets = 0;

                        }
                        else // input entered not number, x or X
                        {
                           System.out.println("ERROR - INVALID INPUT\n");
                           isIntValue = false; // not a correct input
                        }

                     } while (isIntValue == false); // until correct input

                     // selection[0] -> boarding station
                     // selection[1] -> departing station

                     // loop through array stops testing for enough seats
                     for (int row =
                              (int) selection[0]; row < (int) selection[1]; row++)
                     {

                        // test seats accross all stops for class
                        if (childPaidTickets + adultTickets <= excursionClass
                                 .checkSeatAmount(row))
                        {
                           okToBook = true;// All details ok to book tickets
                        }
                        else
                        {
                           // display ticket availability menu
                           Availability(firstClass, standardClass, excursionClass);

                           // display error message
                           System.out
                                    .println("ERROR - TOTAL GREATER THAN AVAILABLE SEATS");
                           System.out
                                    .println("ENTER NEW AMOUNT OR X TO RETURN TO MENU\n");
                           break;
                        }
                     }

                     if (okToBook == true)// All details ok to book tickets
                     {
                        childPaidInputOK = true;// All details ok to book tickets

                        // selection[4] -> number of child paid tickets
                        selection[4] = childPaidTickets;
                     }
                     else
                     {
                        childPaidInputOK = false; // information not ok
                     }

                  }
               }

               // if abort not selected get child ticket information
               if (abort == false)
               {
                  //
                  // define variables and conditions
                  childFreeTickets = 0;
                  okToBook = false;
                  boolean childInputOK = false;

                  // do until childPaidTicket information is correct
                  while (childInputOK == false)
                  {
                     // test for integer value
                     boolean isIntValue = false;
                     do
                     {
                        // Take user input for ticket amount
                        System.out.print("Enter Child ticket amount(0 -> 2): ");
                        String tickets = input.next();

                        // test if number is a number value
                        if (tickets.matches("[0-9]+"))
                        {
                           // if number type convert to integer
                           // assign to new variable adultTickets
                           childFreeTickets = Integer.parseInt(tickets);
                           isIntValue = true; // is correct input
                        }

                        // test if 'x' or 'X' has been selected for abort
                        else if (tickets.matches("x") || tickets.matches("X"))
                        {
                           abort = true; // abort selected
                           isIntValue = true; // exit loop
                           okToBook = false; // dont book tickets

                           // Set ticket numbers to 0
                           childPaidTickets = 0;
                           childFreeTickets = 0;
                           adultTickets = 0;

                        }
                        else // input entered not number, x or X
                        {
                           System.out.println("ERROR - INVALID INPUT\n");
                           isIntValue = false; // is not an integer value
                        }

                     } while (isIntValue == false); // until correct input

                     // selection[0] -> boarding station
                     // selection[1] -> departing station

                     // loop through array stops testing for enough seats
                     for (int row =
                              (int) selection[0]; row < (int) selection[1]; row++)
                     {
                        // test seats accross all stops for class
                        if (childFreeTickets + childPaidTickets +
                            adultTickets <= excursionClass
                                     .checkSeatAmount(row))
                        {
                           okToBook = true;// All details ok to book tickets
                        }
                        else
                        {
                           // display ticket availability menu
                           Availability(firstClass, standardClass, excursionClass);

                           // display error message
                           System.out
                                    .println("ERROR - TOTAL GREATER THAN AVAILABLE SEATS");
                           System.out
                                    .println("ENTER NEW AMOUNT OR X TO RETURN TO MENU\n");
                           break;

                        }

                     }

                     if (okToBook == true)// All details ok to book tickets
                     {
                        childInputOK = true; // information ok

                        // selection[5] -> number of child free tickets
                        selection[5] = childFreeTickets;
                     }
                     else
                     {
                        childInputOK = false;// information not ok
                     }
                  }

               }

               break; // return from case

            case "x": // Main menu
            case "X":
               return false;
            default:
               System.out.println("ERROR - INVALID INPUT\n");
               break;

         }
         // abort not selected
         if (abort == false)
         {
            classInputOK = true; // all user input correct
         }

      } while (classInputOK == false);

      return true;

   }

   // @param: selection -----------> array -> stores use input
   // @param: firstClassSeats -----> array -> stores seats booked
   // @param: standardClassSeats --> array -> stores seats booked
   // @param: excursionClassSeats -> array -> stores seats booked
   // @param: receiptNumber -------> instance of BookingReceipt
   // @param: firstClass ----------> instance of TrainService
   // @param: standardClass -------> instance of TrainService
   // @param: excursionClass ------> instance of TrainService
   // @param: receipt -------------> String --> receipt Number
   // @param: displayForTeacher ---> boolean -> visual array on/off
   // @param: input ---------------> Scanner -> user input

   public static int ticketBooking(Object[] selection, Object[][] firstClass,
                                   Object[][] standardClass,
                                   Object[][] excursionClass, int receiptNumber,
                                   TrainService firstClassSeats,
                                   TrainService standardClassSeats,
                                   TrainService excursionClassSeats,
                                   BookingReceipt<?> receipt,
                                   boolean displayForTeacher, Scanner input)
   {

      // Object[] selection =
      // [ boarding , departing , class , adult , childFree , childPaid];
      //
      // @param firstClass ->
      // ...................TrainService instance
      // ...................For first class seat array
      //
      // TrainService standardClass
      // ...................TrainService instance
      // ...................For standard class seat array
      //
      // TrainService excursionClass
      // ...................TrainService instance
      // ...................For excursion class seat array
      //
      // @param boarding -->
      // ................. 0 = "Castlemaine"
      // ................. 1 = "Campbell"
      // ................. 2 = "Guildford"
      // ................. 3 = "Strangway"
      // ................. 4 = "Newstead"
      // ................. 5 = "Moolort"
      //
      // @param departure ->
      // ................. 0 = "Castlemaine"
      // ................. 1 = "Campbell"
      // ................. 2 = "Guildford"
      // ................. 3 = "Strangway"
      // ................. 4 = "Newstead"
      // ................. 5 = "Moolort"
      //
      // @param class ------>
      // ..................."first Class"
      // ..................."Standard Class"
      // ..................."Excursion Class"
      //
      // @param adult ------>
      // ...................Number of tickets
      //
      // @param childFree -->
      // ...................Number of tickets
      //
      // @param childPaid -->
      // ...................Number of tickets
      //

      // check class ticket seats are available
      if (selection[2] == "First Class")
      {

         // Check if seats available for boarding, departing option
         // firstClass.checkSeat(row, column);
         //
         // @Object[] selection ---------> array -> stores use input
         //
         // selection[0] -> boarding station
         // selection[1] -> departing station
         // selection[2] -> ticket travel class
         // selection[3] -> number of adult tickets
         // selection[4] -> number of child paid tickets
         // selection[5] -> number of child free tickets

         // set default parameters
         String newReceipt = "";
         int receiptCounter = 0;

         // do for ticket amount total
         for (int bookings = 0; bookings < ((int) selection[3]); bookings++)
         {

            boolean seatClear = false; // seat is free initialization condition
            int seatNumber = 0; // starting counter

            // cycles through each seat (array elements 0 to 47)
            for (int checkTickets =
                     0; checkTickets < ((int) selection[3]); checkTickets++)
            {
               for (seatNumber = 0; seatNumber < 48; seatNumber++)
               {

                  seatClear = false; // initialize variable state

                  // test each seat from selected boarding location to departing
                  // location
                  innerBreak: for (int trainStop =
                           ((int) selection[0]); trainStop < ((int) selection[1]); trainStop++)
                  {

                     // check if seat location is free
                     if (firstClass[trainStop][seatNumber] == null)
                     {
                        seatClear = true;// seat not taken

                     }
                     else
                     {
                        seatClear = false; // seat taken
                        break innerBreak; // breaks counting on first seat taken
                     }
                  }
                  if (seatClear == true)
                  { // seat positions free
                     break;
                  }
               }
            }

            if (seatClear == true)
            { // Seat is available

               if (receiptCounter == 0)
               { // generate first receipt

                  newReceipt = receipt.createReceipt(); // Booking receipt method(
                                                        // creates string receipt
                  // display receipt printout on screen
                  receipt.displayReceipt(newReceipt, selection);
                  // increment receipt number counter by 1
                  receiptCounter++;
                  // increment receipt number by 1
                  receiptNumber++;

               }

               // set array positions to book out seats
               for (int bookTickets =
                        0; bookTickets < ((int) selection[3]); bookTickets++)
               {
                  for (int k = ((int) selection[0]); k < ((int) selection[1]); k++)
                  {
                     // sets receipt number into array seat location
                     firstClassSeats.setSeat(k, seatNumber, (newReceipt));
                  }
               }
            }
         }

      }
      else if (selection[2] == "Standard Class")
      {

         // Check if seats available for boarding, departing option
         // standardClass.checkSeat(row, column);
         //
         // @Object[] selection ---------> array -> stores use input
         //
         // selection[0] -> boarding station
         // selection[1] -> departing station
         // selection[2] -> ticket travel class
         // selection[3] -> number of adult tickets
         // selection[4] -> number of child paid tickets
         // selection[5] -> number of child free tickets

         // Test Seats for availability
         String newStandardReceipt = "";
         int receiptCounter = 0;

         // do for ticket amount total
         for (int bookings =
                  0; bookings < (((int) selection[3] + (int) selection[4] +
                                  (int) selection[5])); bookings++)
         {

            boolean seatClear = false; // seat is free initialization condition
            int seatNumber = 0; // seat number initialization

            // cycles through each seat number
            for (int checkTickets =
                     0; checkTickets < ((int) selection[3]); checkTickets++)
            {
               for (seatNumber = 0; seatNumber < 70; seatNumber++)
               {

                  seatClear = false;// initialize variable state

                  // test each seat from selected boarding location to departing
                  // location
                  innerBreak: for (int trainStop =
                           ((int) selection[0]); trainStop < ((int) selection[1]); trainStop++)
                  {

                     // check if seat location is free
                     if (standardClass[trainStop][seatNumber] == null)
                     {
                        seatClear = true;// seat not taken

                     }
                     else
                     {
                        seatClear = false;// seat taken
                        break innerBreak;// breaks counting on first seat taken
                     }
                  }
                  if (seatClear == true)
                  { // seat positions free
                     break;
                  }
               }
            }

            if (seatClear == true)
            { // if seat not taken

               if (receiptCounter == 0)
               { // generate first receipt

                  // Booking receipt method( creates string receipt
                  newStandardReceipt = receipt.createReceipt();
                  // display receipt printout on screen
                  receipt.displayReceipt(newStandardReceipt, selection);
                  // increment receipt number counter by 1
                  receiptCounter++;
                  // increment receipt number by 1
                  receiptNumber++;

               }

               // set array positions to book out seats
               for (int bookTickets =
                        0; bookTickets < ((int) selection[3]); bookTickets++)
               {
                  for (int k = ((int) selection[0]); k < ((int) selection[1]); k++)
                  {
                     // sets receipt number into array seat location
                     standardClassSeats.setSeat(k, seatNumber, (newStandardReceipt));
                  }
               }
            }

         }

      }
      else if (selection[2] == "Excursion Class")
      {

         // Check if seats available for boarding, departing option
         // firstClass.checkSeat(row, column);
         //
         // @Object[] selection ---------> array -> stores use input
         //
         // selection[0] -> boarding station
         // selection[1] -> departing station
         // selection[2] -> ticket travel class
         // selection[3] -> number of adult tickets
         // selection[4] -> number of child paid tickets
         // selection[5] -> number of child free tickets

         // Test Seats for availability
         String newStandardReceipt = "";
         int receiptCounter = 0;

         // do for ticket amount total
         for (int bookings =
                  0; bookings < (((int) selection[3] + (int) selection[4] +
                                  (int) selection[5])); bookings++)
         {

            boolean seatClear = false; // seat is free initialization condition
            int seatNumber = 0; // seat number initialization

            // cycles through each seat number
            for (int checkTickets =
                     0; checkTickets < ((int) selection[3]); checkTickets++)
            {
               for (seatNumber = 0; seatNumber < 95; seatNumber++)
               {

                  seatClear = false;// initialize variable state

                  // test each seat from selected boarding location to departing
                  // location
                  innerBreak: for (int j =
                           ((int) selection[0]); j < ((int) selection[1]); j++)
                  {

                     if (excursionClass[j][seatNumber] == null)
                     {
                        seatClear = true; // seat not taken

                     }
                     else
                     {
                        seatClear = false;// seat taken
                        break innerBreak;// breaks counter on first seat taken
                     }
                  }
                  if (seatClear == true)
                  { // seat positions free
                     break;
                  }
               }
            }

            if (seatClear == true)
            { // if seat not taken

               if (receiptCounter == 0)
               { // generate first receipt

                  // Booking receipt method( creates string receipt
                  newStandardReceipt = receipt.createReceipt();
                  // display receipt printout on screen
                  receipt.displayReceipt(newStandardReceipt, selection);
                  // increment receipt number counter by 1
                  receiptCounter++;
                  // increment receipt number by 1
                  receiptNumber++;

               }
               // set array positions to book out seats
               for (int bookTickets =
                        0; bookTickets < ((int) selection[3]); bookTickets++)
               {
                  for (int k = ((int) selection[0]); k < ((int) selection[1]); k++)
                  {
                     // sets receipt number into array seat location
                     excursionClassSeats.setSeat(k, seatNumber,
                                                 (newStandardReceipt));
                  }
               }
            }
         }
      }

      //
      // Code below is only for teacher, it shows a visual display of array being
      // filled,Receipt numbers fill each seat location accross different arrays
      // For Teacher Demonstration Only
      // Set displayForTeacher to true back at line 19

      if (displayForTeacher == true)
      {

         // displays first class array message
         System.out.println("\nFirst Class Array");
         // displays array contents
         firstClassSeats.displayArrayContents(firstClass);

         // displays standard class array message
         System.out.println("\nStandard Class Array");
         // displays array contents
         standardClassSeats.displayArrayContents(standardClass);

         // displays excursion class array message
         System.out.println("\nExcursion Class Array");
         // displays array contents
         excursionClassSeats.displayArrayContents(excursionClass);
      }
      // END OF TEACHER CODE

      // return number after generation
      return receiptNumber;
   }

   public static void Availability(TrainService firstClass,
                                   TrainService standardClass,
                                   TrainService excursionClass)
   //
   // GUI to display available seats for each stop and each seat class
   // uses TrainService class to source information for stattistics
   //
   // @param: firstClass ----------> instance of TrainService
   // @param: standardClass -------> instance of TrainService
   // @param: excursionClass ------> instance of TrainService
   //

   {
      // GUI for seat availability
      System.out.println("\n\n");
      System.out.println("-".repeat(67));
      System.out.printf(" %s  |   %s   |  %s  |  %s  |\n",
                        "Moolort Heritage Railway", "First", "Standard",
                        "Excursion");
      System.out.printf("     %s     |   %s   |   %s    |    %s    |\n",
                        "Seat Availability", "Class", "Class",
                        "Class");
      System.out.println("-".repeat(67));
      System.out
               .printf("Castlemaine ->   Campbell  |    %d     |     %d     |      %d     |\n",
                       firstClass.checkSeatAmount(0),
                       standardClass.checkSeatAmount(0),
                       excursionClass.checkSeatAmount(0));
      System.out.println("-".repeat(67));
      System.out
               .printf("Campbell    ->   Guildford |    %d     |     %d     |      %d     |\n",
                       firstClass.checkSeatAmount(1),
                       standardClass.checkSeatAmount(1),
                       excursionClass.checkSeatAmount(1));
      System.out.println("-".repeat(67));
      System.out
               .printf("Guildford   ->   Strangway |    %d     |     %d     |      %d     |\n",
                       firstClass.checkSeatAmount(2),
                       standardClass.checkSeatAmount(2),
                       excursionClass.checkSeatAmount(2));
      System.out.println("-".repeat(67));
      System.out
               .printf("Strangway   ->   Newstead  |    %d     |     %d     |      %d     |\n",
                       firstClass.checkSeatAmount(3),
                       standardClass.checkSeatAmount(3),
                       excursionClass.checkSeatAmount(3));
      System.out.println("-".repeat(67));
      System.out
               .printf("Newstead    ->   Moolort   |    %d     |     %d     |      %d     |\n",
                       firstClass.checkSeatAmount(4),
                       standardClass.checkSeatAmount(4),
                       excursionClass.checkSeatAmount(4));
      System.out.println("-".repeat(67));
      System.out.println("\n\n");

   }

}
