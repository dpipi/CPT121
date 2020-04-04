package java.rmit.cpt121.task_2_1_3;

public class Repetition_1C {

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
