package exam01;

public enum Transportation {
    BUS(1400),
    SUBWAY(1300),
    TAXI(4500);


    private final int fare;

    Transportation(int fare) {
        this.fare = fare;
    }
    //위에가 다 이넘상수들
public int getFare() {
        return fare;
}


}
