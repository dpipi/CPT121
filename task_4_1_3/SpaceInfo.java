package task_4_1_3;

public class SpaceInfo {

    private int carParkState;

    SpaceInfo(int carParkState) {
        this.carParkState = carParkState;
    }

    public void setSpace(int carParkState) {

        if (this.carParkState == 1) { // is Vacant
            this.carParkState = carParkState;
        }
    }

    public int getSpace() {
        return this.carParkState;
    }
}