package java.rmit.cpt121.task_2_1_3;

import java.util.Scanner;

public class Repetiton_3A {

    public static void main(String[] args) {

        String secret = "Johanthan";
        String msg = "You Loose";

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);

        int tries = 5; // Set maximum tries

        while (tries >= 0) // Do while tries less than 5
        {
            System.out.println("Enter guess:"); // user message for input
            String test = input.nextLine();// get guess from user
            test = test.toLowerCase(); // convert to lower case for comparison

            int count = 0;
            for (int i = 0; i < test.length(); i++) {

                char tc = test.toLowerCase().charAt(i);

                for (int j = 0; j < secret.length(); j++) {
                    char sc = secret.toLowerCase().charAt(j);

                    if (tc == sc) {
                        count++;
                        break;
                    }

                }

            }
            if (secret.length() == count) {
                msg = "You Win";
                break;
            } else {
                tries--;
            }
            System.out.printf("You have %d Letters Correct!!!\n", count);
            System.out.printf("You Have %d tries left!\n", tries);

            if (tries == 5) {
                break;
            }
        }
        System.out.println(msg);

    }

}