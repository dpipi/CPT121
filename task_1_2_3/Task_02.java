/*
*2.  Write a program that will read the marks of three students as integer values using the Scanner
 *    class and display the following:
 *    a) average mark across the three students (to two decimal places)
 *    b) the maximum mark obtained
 *    c) the minimum mark obtained
 *    Note that you may find methods in the Math class useful for points b) and c) of this task and it
 *    is not necessary to use decisions to identify the required values for these points.
 */

package task_1_2_3;

import java.util.Scanner;

public class Task_02
{

   public static void main(String[] args)
   {
      // create user input scanner
      Scanner input = new Scanner(System.in);

      // get user input for student 1
      System.out.println("Enter 1st students score as an integer value: ");
      int firstStudentScore = input.nextInt();

      // get user input for student 2
      System.out.println("Enter 2nd students score as an integer value: ");
      int secondStudentScore = input.nextInt();

      // get user input for student 3
      System.out.println("Enter 3rd students score as an integer value: ");
      int thirdStudentScore = input.nextInt();

      // close scanner
      input.close();

      // get average mark
      float average =
               (firstStudentScore + secondStudentScore + thirdStudentScore) / 3;

      // Get maximum mark
      int maximumMarkObtained =
               Math.max(firstStudentScore,
                        Math.max(secondStudentScore, thirdStudentScore));
      // get minimum mark
      int minimumMarkObtained =
               Math.min(firstStudentScore,
                        Math.max(secondStudentScore, thirdStudentScore));

      // display output
      System.out.printf("%-15S %-15S %-15S", "Average Mark", "Maximum Mark",
                        "Minimum Mark")
               .println();
      System.out.printf("%-15.0f %-15d %-15d", average, maximumMarkObtained,
                        minimumMarkObtained);
   }

}
