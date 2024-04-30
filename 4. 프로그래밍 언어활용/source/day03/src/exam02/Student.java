package exam02;

public class Student {
    public static int id;
    private String name = "이이름";
    private String subject;

    public static void staticMethod() {
        System.out.println("정적 메서드!!");

//        this.name="ㅇ이름";  객체와 상관없이 사용 가능 , this 지역 변수 x ->객체 자원 접근
    }


    public void instanceMethod() { //this 지역변수 0 : 객체 자원 접근
        System.out.println("인스턴스 메서드!!");
        System.out.println(name);
        System.out.println(this.name);

    }



    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}