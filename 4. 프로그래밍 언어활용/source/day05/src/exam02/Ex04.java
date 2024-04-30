package exam02;

public class Ex04 {
    public static void main(String[] args) {
        A ad = new D();

        A ac = new C();

        if (ad instanceof C) {


            C c = (C) ad;  // 지금 앞에 (C)써로 바꿔줘야 오류가 안 생김
        }

        if (ac instanceof C) {
            C cc = (C) ac; // => (C)앞에 출처를 명시}
            System.out.println(cc.numC);


        }
    }
}
