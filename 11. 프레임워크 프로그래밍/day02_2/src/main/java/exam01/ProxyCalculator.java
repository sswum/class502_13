package exam01;

public class ProxyCalculator implements Calculator {

    //ImplCalculator ,  RecCalculator 대신 수행해 주려면? 다형성을 이용해야 한다.
    //다형성은 많은 유연성을 제공한다.

    private Calculator calculator;
    //개방 폐쇄원칙이 그래서 나왔다. 고정하는 건 좋지않다 (?) 잘모르겠음.
    //수업 다시 듣기

    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;

    }


    @Override
    public long factorial(long num) {
        long stime = System.nanoTime();

        try{

        //다른 계산기의 핵심 기능을 대신 수행
        long result = calculator.factorial(num); //다른 계산기의 factorial 연산을 대신 수행

        return result;
    } finally {
            //return하더라도 finally를 쓰면 다시 돌아서 값이 나오게끔
            long etime = System.nanoTime();
            System.out.printf("걸린시간: %d%n" ,etime - stime);

        }
        }
}
