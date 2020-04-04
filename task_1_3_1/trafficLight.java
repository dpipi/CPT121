/*
 * Write a program which simulates the logic of a traffic light, based on the road rules for traffic
 * light signals as outlined at https://www.vicroads.vic.gov.au/safety-and-road-rules/roadrules/
 * a-to-z-of-road-rules/traffic-controls-at-intersections (basic Traffic lights rules only), and
 * prints the appropriate outcome according to the prevailing conditions (ie. either �stop� or
 * �proceed through intersection�).
 * Note that there are multiple factors to take into account when approaching a traffic light and
 * your program should gather information from the user about each of these factors as when /
 * as required and take each of these factors into account, as outlined in the rules for basic
 * Traffic lights noted above
 */

package task_1_3_1;

import java.util.Scanner;

public class trafficLight
{

   public static void main(String[] args)
   {
      // create scanner to receive user input
      Scanner sc = new Scanner(System.in);

      // traffic light color
      System.out.println("Enter color of traffic light(red, amber or green): ");
      String lightColor = sc.nextLine();

      // pedestrian walking
      System.out.println("Enter padestrian in way (yes or no): ");
      String pedestrian = sc.nextLine();

      // test against light color
      if (lightColor.equalsIgnoreCase("red"))
      {
         System.out.println("stop");
      }
      else if (lightColor.equalsIgnoreCase("amber"))
      {
         System.out.println("stop");
      }
      else
      {
         if (pedestrian.equalsIgnoreCase("yes"))
         {
            System.out.println("stop");
         }
         else
         {
            System.out.println("proceed through intersection");
         }

      }
      sc.close();
   }

}
