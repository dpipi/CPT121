package task_4_1_3;

import java.util.Scanner;

public class CarParkMonitoringSystem {

   private static final int LEVELS = 3;
   private static final int SPACES_PER_LEVEL = 12;

   private static final int OCCUPIED = 0;
   private static final int VACANT = 1;
   private static final int OUT_OF_SERVICE = 2;

   // this array declaration needs to be updated
   private static final int[][] carParkSpaces = new int[LEVELS][SPACES_PER_LEVEL];

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
               initializeCarParkSpaces();
               break;
            case "B":
               spaceEntered();
               break;
            case "C":
               spaceVacated();
               break;
            case "D":
               displayCarParkStatus(carParkSpaces);
               break;
            case "E":
               putSpaceInService();
               break;
            case "F":
               returnSpaceFromService();
               break;
            default:
               System.out.println("Invalid selection - please try again");

         }
      } while (selection.toUpperCase() != "X");
      sc.close();
   }

   // set all spaces to vacant
   private static void initializeCarParkSpaces() {
      for (int level = 0; level < carParkSpaces.length; level++) {
         for (int spaceNumber = 0; spaceNumber < carParkSpaces[0].length; spaceNumber++) {
            carParkSpaces[level][spaceNumber] = VACANT;
         }
      }
   }

   private static int getLevelIndex(char level) {
      return level - 'A';
   }

   // SPACE ENTERED METHOD
   private static void spaceEntered() {
      System.out.println("Enter level (A, B or C): ");
      char level = sc.nextLine().toUpperCase().charAt(0);

      System.out.println("Enter space number (0 - 11");
      int spaceNumber = sc.nextInt();

      // clean up trailing newline
      sc.nextLine();

      int levelIndex = getLevelIndex(level);

      // insert new code here to update corresponding SpaceInfo object
      carParkSpaces[levelIndex][spaceNumber] = OCCUPIED;

   }

   // SPACE VACATED METHOD
   private static void spaceVacated() {
      System.out.println("Enter level (A, B or C): ");
      char level = sc.nextLine().toUpperCase().charAt(0);

      System.out.println("Enter space number (0 - 11");
      int spaceNumber = sc.nextInt();

      // clean up trailing newline
      sc.nextLine();

      int levelIndex = getLevelIndex(level);

      // insert new code here to update corresponding SpaceInfo object
      carParkSpaces[levelIndex][spaceNumber] = VACANT;

   }

   // DISPLAY CAR PARK STATUS METHOD
   public static void displayCarParkStatus(int[][] carParkSpaces) {
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

      System.out.println("Enter space number (0 - 11");
      int spaceNumber = sc.nextInt();

      // clean up trailing newline
      sc.nextLine();

      int levelIndex = getLevelIndex(level);

      // insert new code here to update corresponding SpaceInfo object
      carParkSpaces[levelIndex][spaceNumber] = VACANT;
   }

   // PUT SPACE INTO SERVICE METHOD
   private static void putSpaceInService() {
      System.out.println("Enter level (A, B or C): ");
      char level = sc.nextLine().toUpperCase().charAt(0);

      System.out.println("Enter space number (0 - 11");
      int spaceNumber = sc.nextInt();

      // clean up trailing newline
      sc.nextLine();

      int levelIndex = getLevelIndex(level);

      // insert new code here to update corresponding SpaceInfo object
      carParkSpaces[levelIndex][spaceNumber] = OUT_OF_SERVICE;
   }
}
