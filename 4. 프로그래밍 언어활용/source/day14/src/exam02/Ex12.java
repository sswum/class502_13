package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex12 {
    public static void main(String[] args) {
        int[] nums = {33, 10, 5, 1, 3, 88, 100, 10};
        int[] nums2 = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(nums2));
        //오름차순으로 정렬이 되고 있다.
        //Arrays.stream(nums) 요걸로 정렬되면 IntStream으로 나옴 그 인트스트림으로 나온 걸 솔티드 해서
        int[] nums3 = Arrays.stream(nums).boxed()                   //기본에서 일반스트림으로 boxed가 바꿔줌.
                .sorted(Comparator.reverseOrder())
                .mapToInt(x -> x)
                .toArray();
        System.out.println(Arrays.toString(nums3));
    }
}
