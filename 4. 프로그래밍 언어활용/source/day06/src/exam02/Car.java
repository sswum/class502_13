package exam02;

public abstract class Car {
    public abstract void start();
    public abstract void press();
    public abstract void turnoff();


    public void run() {

        start();
        press();
        turnoff();

    }

}

