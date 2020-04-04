package task_2_1_1;

import java.util.Scanner;

public class AverageMark01 {

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter marks (-1) to terminate");

        int count = 0;
        int total = 0;

        boolean exit = false;
        while (exit != true) {
            System.out.println("Enter mark:");
            final int mark = input.nextInt();
            if (mark == -1) {
                exit = true;
            } else {
                total = total + mark;
                count++;
            }

        }

        input.close();

        System.out.println("average mark is: " + total / count);

    }

}