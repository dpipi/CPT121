package java.rmit.cpt121.task_2_3_3;

import java.util.Scanner;

public class Temperatures {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Display msg and get days per month as input
        System.out.print("Enter Days in the month:");
        int daysInMonth = input.nextInt();

        // Set array length to saysInMonth number
        int[] maxTempArray = new int[(daysInMonth)];
        int[] minTempArray = new int[(daysInMonth)];

        int count = 0;
        do {

            // get low temp for day count
            System.out.printf("Enter Maximum temperature for day %d :", count + 1);
            int maxTempValue = input.nextInt();
            // Store high temperature value in lowTempArray
            store(maxTempArray, maxTempValue, count);

            // get low temp for day count
            System.out.printf("Enter Minimum temperature for day %d :", count + 1);
            int minTempValue = input.nextInt();
            // Store low temperature value in lowTempArray
            store(minTempArray, minTempValue, count);

            // increment count
            count++;

        } while (count < (daysInMonth));

        input.close();

        // display average temperatures for both maximums and minimums
        System.out.println("The average maximum temperature was: " + average(maxTempArray, count));
        System.out.println("The average minimum temperature was: " + average(minTempArray, count));

        System.out.println();// space between statements

        // display highest and lowest maximum temperature for month
        System.out.println("The highest maximum temperature was: " + maximum(maxTempArray, count));
        System.out.println("The lowest maximum temperature was: " + minimum(maxTempArray, count));

        System.out.println();// space between statements

        // display highest and lowest minimum temperature for month
        System.out.println("The highest minimum temperature was: " + minimum(minTempArray, count));
        System.out.println("The lowest minimum temperature was: " + minimum(minTempArray, count));

        System.out.println();// space between statements

        // display number of days above average temperature for month
        System.out.println(
                "Days above average for month: " + daysAboveAverage(maxTempArray, average(minTempArray, count), count));

    }

    /*
     * Store value in arrar at specified location.
     */
    private static void store(int[] array, int value, int location) {
        // Store value in array
        array[location] = value;

    }

    /*
     * Get average of all values in array
     */
    @SuppressWarnings("unused")
    private static double average(int[] array, int size) {
        double total = 0;

        for (int location = 0; location < size; location++) {
            total = total + array[location];
        }

        double averageValue = total / size;

        return averageValue;

    }

    /*
     * Get highest value
     */
    public static int maximum(int[] array, int size) {
        int maximumValue = 0;

        for (int location = 0; location < size; location++) {
            if (array[location] > maximumValue) {
                maximumValue = array[location];
            }
        }

        return maximumValue;

    }

    /*
     * Get lowest value
     */
    public static int minimum(int[] array, int size) {
        int minimumValue = 150; // Value covers both C and F temps

        for (int location = 0; location < size; location++) {
            if (array[location] < minimumValue) {
                minimumValue = array[location];
            }
        }

        return minimumValue;

    }

    /*
     * Get days above average
     */
    public static int daysAboveAverage(int[] array, double averageTemp, int size) {
        int daysAboveAverage = 0;

        for (int location = 0; location < size; location++) {
            if (array[location] > averageTemp) {
                daysAboveAverage++;
            }
        }

        return daysAboveAverage;
    }

}
