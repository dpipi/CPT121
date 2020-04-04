package task_2_1_1;

import java.util.Scanner;

public class AverageMark02
{

   public static void main(final String[] args) {

      final Scanner input = new Scanner(System.in); // create scanner

      System.out.println("Enter marks (-1) to terminate");

      int mark = 0; // Mark input from user
      int total = 0; // total of all marks entered
      int count = 0; // number of marks entered

      while (mark != -1)
      {
         System.out.print("Enter Mark: ");
         mark = input.nextInt();

         if (mark != -1)
         {
            total = total + mark;
            count++;
         }
      }

      input.close(); // close scanner

      System.out.println("Aver = " + (double) total / count);

   }

}