/*
 * 2. Assuming that the types of the variables x, y, and z are int, float and double respectively, 
 * which of the following statement(s) are likely to result in error ?
 * a) x = y; // error
 * b) x = z; // error
 * c) y = x; // OK
 * d) y = z; // error
 * e) z = x; // OK
 * f) z = y; // OK
 */

package task_1_1_3;

public class Task_02
{

   public static void main(String[] args)
   {
      int x;
      float y;
      @SuppressWarnings("unused")
      double z;

      x = 5;
      y = 5f;
      z = 5;

      // x = y;
      // x = z;
      y = x;
      // y = z;
      z = x;
      z = y;

   }

}
