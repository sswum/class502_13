package ex03;

public class Ex05 {
    public static void main(String[] args) {
        String str = "I like java and javascript";
        boolean mathched = str.matches(".*java.*");
        System.out.println(mathched);

        String str2 = "               ABC           ";
        String str3 = str2.stripLeading();
        String str4 = str2.stripTrailing();
        System.out.println(str2);
        System.out.println(str3); // 오른쪽 여백 남아있음
        System.out.println(str4); //왼쪽 여백 남아있음

    }
}
