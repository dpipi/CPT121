package java.rmit.cpt121.task_2_2_3;

import java.util.Scanner;

public class Temperatures {

    // For averages
    private static int maxTempTotal = 0; // total of all maximum temperatures
    private static int minTempTotal = 0; // total of all minimum temperatures

    // for maximum temperature range
    private static int highMaxTemp = 0; // highest temperature of maximum values
    private static int lowMaxTemp = 100; // highest temperature of maximum values

    // for minimum temperature range
    private static int highMinTemp = 0; // lowest temperature of minimum values
    private static int lowMinTemp = 100; // highest temperature of maximum values

    public static void main(String[] args) {

        // Create Scanner for user input
        Scanner input = new Scanner(System.in);

        // ask user for days in month
        System.out.print("Enter days month:");
        int daysInMonth = input.nextInt();

        // Set array lengths
        int[] minimumTemp = new int[daysInMonth];
        int[] maximumTemp = new int[daysInMonth];

        // get temperature data from user for each element location(each day)
        int count = 0;
        do {
            // get maximum temperature for day
            System.out.printf("Enter maximum temperature for day %d:", (count + 1));
            int maximum = input.nextInt();
            // get minimum temperature for day
            System.out.printf("Enter minimum temperature for day %d:", (count + 1));
            int minimum = input.nextInt();

            minimumTemp[count] = minimum; // store value at index count
            maximumTemp[count] = maximum; // store value at index count

            count++;
            System.out.println(); // spacer

        } while (count < daysInMonth);

        input.close(); // Close Scanner

        for (int i = 0; i < daysInMonth; i++) {
            // Get maximum and minimum totals
            maxTempTotal = maxTempTotal + maximumTemp[i];
            minTempTotal = minTempTotal + minimumTemp[i];

            // Get maximum and minimum temperature of high temps
            if (maximumTemp[i] > highMaxTemp) {
                highMaxTemp = maximumTemp[i];
            }
            if (maximumTemp[i] < lowMaxTemp) {
                lowMaxTemp = maximumTemp[i];
            }

            // Get maximum and minimum temperature of low temps
            if (minimumTemp[i] > highMinTemp) {
                highMinTemp = minimumTemp[i];
            }
            if (minimumTemp[i] < lowMinTemp) {
                lowMinTemp = minimumTemp[i];
            }

        }

        int daysAboveAverage = 0;
        for (int i = 0; i < daysInMonth; i++) {
            if (maximumTemp[i] > (maxTempTotal / daysInMonth)) {
                daysAboveAverage++;
            }
        }

        // Output Information for user
        System.out.println("Average maximum temperature for the month is:" + (maxTempTotal / daysInMonth));
        System.out.println("Average minimum temperature for the month is:" + (minTempTotal / daysInMonth));

        // highest and lowest maximum temperature
        System.out.println("Highest max Temp: " + highMaxTemp);
        System.out.println("Lowest  max Temp: " + lowMaxTemp);
        // highest and lowest minimum temperature
        System.out.println("Highest min Temp: " + highMinTemp);
        System.out.println("Lowest  min Temp: " + lowMinTemp);

        System.out.println("Days above average: " + daysAboveAverage);

    }

}
