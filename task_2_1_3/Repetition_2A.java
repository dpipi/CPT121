package java.rmit.cpt121.task_2_1_3;

import java.util.Scanner;

public class Repetition_2A {
    public static void main(String[] args) {
        int lowest = 100;
        int highest = 0;

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        // display initial message
        System.out.println("Enter a integer number between 1 and 100\n");

        // do until inout = -1
        boolean test = false;
        while (test != true) {
            System.out.println("Enter number(-1 to exit): ");
            int prompt = input.nextInt();

            if (prompt == -1) {
                test = true;
            } else {
                if (prompt < lowest) {
                    lowest = prompt;
                }
                if (prompt > highest) {
                    highest = prompt;
                }
            }

        }
        System.out.printf("Lowest number was: %d\n", lowest);
        System.out.printf("Highest number was: %d\n", highest);
    }
}