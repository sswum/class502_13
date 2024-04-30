package exam01;

import java.util.StringTokenizer;

public class Ex04 {
    public static void main(String[] args) {
        String fruits = "Apple#Orange,Melon+Banana";
        //#이 토큰이 되는것!
        StringTokenizer st = new StringTokenizer(fruits, "#,+");

        while (st.hasMoreTokens()) {
            String fruit = st.nextToken();
            System.out.println(fruit);

            //token이 많을 때는 # + , 여러개 써도 된다.

        }

    }
}
