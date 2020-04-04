/*
 *    Write a program which reads in values for the user�s name, day, time, temperature (to one
 *    decimal place), weather conditions (eg. sunny, cloudy, rain, storms, etc) and rain in the past 25
 *    hours (value in mm to one decimal place) and prints out this information in a neat, labelled
 *    and tabulated format (ie. all labels and values are aligned in columns).
 *    The input values must be prompted for and read in the order specified and you may find the
 *    printf() method useful when printing your output.
 */

package task_1_2_3;

import java.util.Scanner;

public class Task_01
{

   public static void main(String[] args)
   {

      // create Scanner for user input
      Scanner userInput = new Scanner(System.in);

      // ask user to enter their name
      System.out.println("Please enter your name: ");
      String name = userInput.nextLine();

      // ask user to enter day of the week
      System.out.println("Enter day of the week: ");
      String day = userInput.next();

      // ask user to enter current time
      System.out.println("Enter current time (12:45)");
      String time = userInput.next();

      // ask user to enter temperature to one decimal place
      System.out.println("Enter temperature in celsius (to one decimal place!)");
      String temperature = userInput.next();

      // ask user to enter weather conditions (eg. sunny, cloudy, rain, storms, etc)
      System.out
               .println("Enter weather conditions (eg. sunny, cloudy, rain, storms, etc)");
      String weather = userInput.next();

      // ask user to enter amount of rain in mm
      System.out.println("Enter rain in last 24 hours as a number (millimeters)");
      String rain = userInput.next();

      userInput.close();

      // Display output
      System.out.printf("%-15S %-15S %-15S %-15S %-15S %-15S", "name", "day", "time",
                        "temperature", "weather", "rain")
               .println();
      System.out.printf("%-15S %-15S %-15S %-15S %-15S %-15S", name, day, time,
                        temperature, weather, rain);
   }

}
