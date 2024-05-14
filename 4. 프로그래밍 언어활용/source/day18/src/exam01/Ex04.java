package exam01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex04 {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss E");
        LocalDateTime starDate = LocalDateTime.of(2024, 3, 9, 9, 0);
        String strDate = formatter.format(starDate);
        System.out.println(strDate);
    }
}
