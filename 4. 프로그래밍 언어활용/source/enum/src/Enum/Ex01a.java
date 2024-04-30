package Enum;

public class Ex01a {
    public static void main(String[] args) {

      //  Week w=Week.FRIDAY;
       // String weekName = w.name();
    //    System.out.println(weekName);

        Week w=Week.FRIDAY;
        int weekNum = w.ordinal();
        System.out.println(weekNum);
    }
}
