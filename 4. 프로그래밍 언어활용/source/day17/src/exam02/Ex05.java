package exam02;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Ex05 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate lastyear = today.with(ChronoField.YEAR, 2023);
        System.out.println("변경X:" + today);

        System.out.println("변경 O:" + lastyear);
    }
}
