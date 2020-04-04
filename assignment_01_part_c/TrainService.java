package assignment_01_part_c;

//
// Class TrainService stores and manipulates information relevant 
// to the train journey such as what stations comprise the journey 
// and how many of each seat type are available throughout the journey. 
// Arrays should still be used by the class to store this information.
//

public class TrainService {

    private Object[][] classType;

    public TrainService(String[][] classType) {
        this.classType = classType;
    }

    public Object checkSeat(int row, int column) {
        Object detail = classType[row][column];
        return detail;
    }

    public void setSeat(int row, int column, String receipt) {
        this.classType[row][column] = receipt;

    }

    public int checkSeatAmount(int row) {
        int count = 0;
        for (int element = 0; element < this.classType[0].length; element++) {
            if (this.classType[row][element] != null) {
                count++;
            }
        }

        return (classType[row].length - count);
    }

    public void displayArrayContents(Object[][] testArray) {
        /*
         * This code is only there for teachers demonstration and to be able to show the
         * arrays when filled, you can comment
         * 
         */

        for (int m = 0; m < 5; m++) {
            for (int n = 0; n < testArray[0].length; n++) {
                System.out.print(testArray[m][n]);
                if (testArray[m][n] == null) {
                    System.out.print("      ");

                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

}
