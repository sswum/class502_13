package exam02;

public class Ex04 {
    public static void main(String[] args) {
        String[] strs = {"가나", "다라", "마바"};
      /*  for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);*/

        //향상된 for문
        for (String str : strs) {
            System.out.println(str);
        }
        }
    }

