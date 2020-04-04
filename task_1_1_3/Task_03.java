/*The following code segment prints an incorrect result (instead of the expected result of sqr = 10000000000)
 * 
 * int num1 = 100000;
 * int sqr = num1 * num1;
 * System.out.println("sqr = " + sqr);
 * 
 * Describe the problem / error that has occurred and suggest a solution or work-around to the 
 * problem which will allow the correct result to be stored and printed.
 */

package task_1_1_3;

public class Task_03
{

   public static void main(String[] args)
   {

      // The folowing code would not calculate correctly
      int num1 = 100000;
      int sqr = num1 * num1;
      System.out.println("sqr = " + sqr);

      // The error is due to the calculation being greater than an integer type can
      // handle
      // my suggestion would be to either change variable 'num' to a long
      // or you could type cast in the variable 'sqr'
      int num2 = 100000;
      long sqr2 = (long) num2 * (long) num2;
      System.out.println("sqr = " + sqr2);

   }

}
