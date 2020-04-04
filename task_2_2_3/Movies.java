package task_2_2_3;

import java.util.Scanner;

public class Movies {

    public static void main(final String[] args) {

        final int length = 10; // amount of movies
        final String[] movies = new String[length];
        // Setup Scanner for user input
        final Scanner input = new Scanner(System.in);

        System.out.printf("Enter %d movies\n", length);

        int count = 0;

        do // Get 10 movies titles from user
        {
            // set msg for input
            System.out.print("Enter movie title " + (count + 1) + ":");
            // get input
            final String movie = input.nextLine();
            if (movie.isBlank()) {
                break;
            }

            // add movie to array
            movies[count] = movie;

            count++;
        } while (count < length);

        System.out.println("Enter key word to search:");

        final String keyword = input.nextLine();

        input.close();

        for (int i = 0; i < count; i++) {
            if (movies[i].toLowerCase().contains(keyword.toLowerCase()) && movies[i] != null) {
                System.out.println(movies[i]);
            }

        }
    }

}