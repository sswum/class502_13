package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data.txt"));
        //원래 Scanner쪽에 오류가 떠서 thowrs FileNotFoundException 따로 씀

        int total=0;
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println(num);


        }
        System.out.println(total);
    }
}
