package exam01;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        String[] fruits1 = {"사과", "오렌지", "망고", "멜론"};
        String[] fruits2 = {"사과", "오렌지", "바나나", "포도"};

        int pos = Arrays.mismatch(fruits1, fruits2); // 동일한 경우 -1
        System.out.println(pos); //결과값 2  인덱스번호2번에서 차이점이 발생한 위치의 값을 반환
    }
}
