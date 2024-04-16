package exam01;

public class Student {

        int id; // 학번
        String name; // 이름
        String subject; // 과목

    public Student() {
        id= 1000;
        name = "이이름";
        subject = "자바";

    }

        public Student(int _id, String _name, String _subject) { //기본 생성자(Default 생성자)
//객체가 생성된 이후 실행 코드
            //실행 시점? id, name, subject에 공간을 할당 받은 상태
// 인스턴스 변수의 초기화 작업을 주로 수행
            id= _id;
            name=_name;
            subject =_subject;
                    System.out.println("객체 생성 이후 실행되는 코드");
        }



        void study() {
            System.out.printf("학번:%d,%s가 %s를 공부한다.%n",id, name, subject);
        }
    }

//void는 반환값이 없을 때 써서 자바한테 알려주는 (비어있다)