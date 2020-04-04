package task_4_1_3;

import java.util.Scanner;

public class CarParkMonitoringSystem {
   private final static int LEVELS = 3;
   private final static int SPACES_PER_LEVEL = 30;
   private final static boolean OCCUPIED = true;
   private final static boolean VACANT = false;
   private final static boolean SERVICE = false;
   private final static boolean INVALID_SPACE = false;

   // this array declaration needs to be updated
   private static final boolean[][] carParkSpaces = new boolean[LEVELS][SPACES_PER_LEVEL];

   private final static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {

      String selection;

      do {
         // display menu options and prompt user for selection
         System.out.println("*** Car Park Monitoring System ***");
         System.out.println();
         System.out.println("A - Create / Reset Car Park Spaces");
         System.out.println("B - Record Car Parked");
         System.out.println("C - Record Car Exited");
         System.out.println("D - Display Car Park Status");
         System.out.println("E - Put space into service");
         System.out.println("F - Return space from service");
         System.out.println("X - Exit Program");
         System.out.println();

         System.out.print("Enter selection: ");
         System.out.println();
         selection = sc.nextLine().toUpperCase();

         // process menu selection and trigger corresponding helper method
         switch (selection) {
            case "A":
               spaceEntered();
               break;
            case "B":
               spaceVacated();
               break;
            case "C":
               displayCarParkStatus(carParkSpaces);
               break;
            case "D":
               putSpaceInService();
               break;
            case "E":
               returnSpaceFromService();
               break;
            default:
               System.out.println("Invalid selection - plese try again");

         }
      } while (selection.toUpperCase() != "X");
      sc.close();
   }

   private static int getLevelIndex(char level) {
      return level - 'A';
   }

   // SPACE ENTERED METHOD
   private static void spaceEntered() {
      System.out.println("Enter level (A, B or C): ");
      char level = sc.nextLine().toUpperCase().charAt(0);

      System.out.println("Enter space number (0 - 29");
      int spaceNumber = sc.nextInt();

      // clean up trailing newline
      sc.nextLine();

      int levelIndex = getLevelIndex(level);

      // insert new code here to update corresponding SpaceInfo object

   }

   // SPACE VACATED METHOD
   private static void spaceVacated() {
      System.out.println("Enter level (A, B or C): ");
      char level = sc.nextLine().toUpperCase().charAt(0);

      System.out.println("Enter space number (0 - 29");
      int spaceNumber = sc.nextInt();

      // clean up trailing newline
      sc.nextLine();

      int levelIndex = getLevelIndex(level);

      // insert new code here to update corresponding SpaceInfo object

   }

   // DISPLAY CAR PARK STATUS METHOD
   public static void displayCarParkStatus(boolean[][] carParkSpaces) {
      // calculate total number of spaces available
      int levels = carParkSpaces.length;
      int spacesPerLevel = carParkSpaces[0].length;

      int totalSpaces = levels * spacesPerLevel;

      int occupiedSpaces = 0;

      // count all occupied spaces across the three levels of the car park
      for (int i = 0; i < carParkSpaces.length; i++) {
         for (int j = 0; j < carParkSpaces[i].length; j++) {
            if (carParkSpaces[i][j] == OCCUPIED) {
               occupiedSpaces++;
            }
         }

         // determine current car park status
         if (occupiedSpaces == totalSpaces) {
            System.out.println("*** CAR PARK FULL ***");
         } else {
            System.out.println("*** CAR PARK OPEN ***");
         }

         // display current car park usage stats
         System.out.println("Spaces used: " + occupiedSpaces);
         System.out.println("Spaces available: " + (totalSpaces - occupiedSpaces));
      }
   }

   // RETURN SPACE FROM SERVICE METHOD
   private static void returnSpaceFromService() {
      System.out.println("Enter level (A, B or C): ");
      char level = sc.nextLine().toUpperCase().charAt(0);

      System.out.println("Enter space number (0 - 29");
      int spaceNumber = sc.nextInt();

      // clean up trailing newline
      sc.nextLine();

      int levelIndex = getLevelIndex(level);

      // insert new code here to update corresponding SpaceInfo object

   }

   // PUT SPACE INTO SERVICE METHOD
   private static void putSpaceInService() {
      System.out.println("Enter level (A, B or C): ");
      char level = sc.nextLine().toUpperCase().charAt(0);

      System.out.println("Enter space number (0 - 29");
      int spaceNumber = sc.nextInt();

      // clean up trailing newline
      sc.nextLine();

      int levelIndex = getLevelIndex(level);

      // insert new code here to update corresponding SpaceInfo object

   }
}
