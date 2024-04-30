package exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("b.txt");

            System.out.println("파일 작업...");

            fis.close(); // IOException
            System.out.println("자원해제 완료!");
        } catch (IOException e) {
            e.printStackTrace();
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e2) {

                }
            }
//fis는 뭘까요?? catch의 기능을 뭘까요??
        } finally {
            if(fis != null ) {
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }
        }

    }
}