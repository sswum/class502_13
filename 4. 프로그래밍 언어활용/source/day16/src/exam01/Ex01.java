package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13,14};
        boolean isOdd = Arrays.stream(nums).allMatch(x -> x % 2 == 1);
        System.out.println(isOdd); //짝수가 있으면 false값 나옴

        boolean isEven = Arrays.stream(nums).anyMatch(x -> x % 2 == 0);
        System.out.println(isEven);

        boolean notIncludeEven = Arrays.stream(nums).noneMatch(x -> x % 2 == 0);
        System.out.println(notIncludeEven);//전부다 참이여야함...


    }
}
