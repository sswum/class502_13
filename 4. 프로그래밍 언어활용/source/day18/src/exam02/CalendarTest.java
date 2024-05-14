package exam02;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CalendarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("년 월 입력:");
           String input = sc.nextLine();

           if (input.equals("exit")) {
                System.out.println("종료 합니다.");
                break;
            }
            try{
                String[] data = input.split("\\s+");
                int year = Integer.parseInt(data[0]);
                int month = Integer.parseInt(data[1]);
                System.out.printf("---- %d년 %d월 -----%n", year, month);
                System.out.println("일  월  화  수  목  금  토 ");

                int[] days = getCalendar(year, month);
                for (int i = 0; i < days.length; i++) {

                    int day = days[i];
                    if (day > 0) {
                        System.out.printf("%02d  ",day);  //%2d 2에 따라서 공백이 생기도록 표시한 것
                    } else {
                        System.out.print("    ");
                    }
                    if ((i + 1) % 7 == 0) {
                        System.out.println();

                    }
                }

                System.out.println(Arrays.toString(days));

            }catch (Exception e) { //숫자 형식 오류가 발생한 경우
                System.out.println("입력 형식이 잘못되었습니다. 입력 예) 2024 5");
                continue;
        }
    }
}

    public static int[] getCalendar(int year, int month) {
        /**
         * 1. 매월의 1일이 어떤 요일에 시작하는지
         * 2. 매월의 종료일이 무엇인지(30,31,28,29) =>이게 제일 중요한 로직이다.
         */

        LocalDate starDate = LocalDate.of(year, month, 1);
        LocalDate endDate= starDate.plusMonths(1).minusDays(1);

        int yoil = starDate.getDayOfWeek().getValue()%7 ; // 0(월)~6(일) 마지막을 나눴을 때 0이라 이렇게썼다함.
        int start = yoil * -1 +1;


        int[] days = IntStream.rangeClosed(start, endDate.getDayOfMonth()).toArray();


        return days;
    }
}
