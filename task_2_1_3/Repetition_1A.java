package task_2_1_3;

public class Repetition_1A {

    public static void main(String[] args) {
        // Write a program from 1 to 100 that are not a multiple of three
        // 1 2 4 5 7 8 10 11 ... 98 100

        for (int number = 1; number <= 100; number++) {
            if (number % 3 != 0) {
                System.out.print(number + " ");

            }
        }

    }

}