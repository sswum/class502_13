package exam02;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex09 {
    public static void main(String[] args) {
        ZonedDateTime zdt1 = ZonedDateTime.now(); //현재 시간타임의 시간이 세계시간으로 몇시간 떨어져있는지 써있음
        System.out.println(zdt1);

        ZoneId london = ZoneId.of("Europe/London");
        ZonedDateTime londonZdt = zdt1.withZoneSameInstant(london);
        System.out.println(londonZdt);

        ZonedDateTime newYorkZdt = zdt1.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(newYorkZdt);
        //ZoneId.getAvailableZoneIds().forEach(System.out::println);

    }
}
