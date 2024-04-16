package exam01;

public class Ex01 {
    public static void main(String[] args) {
       Student s1 = new Student();
        s1.id = 1000; //인스턴스 변수
        s1.name = "이이름";
        s1.subject = "자바";
        System.out.println(s1.id);
        s1.study(); //인스턴스 메서드

        Student s2= new Student();
        s2.id  = 1001;
        s2.name = "김이름";
        s2.subject= "자바스크립트";

        s2.study();
        System.out.println(s1==s2);

        Student s3 = s2; //s2의 주소를 s3이 가져갔다
        s3.name = "(수정)김이름";
        s3.study(); // s2의 주소가 복사된거라 s2도 이름이 바껴짐
        s2.study();

        s1= null;
        s1.study();
    }
}
