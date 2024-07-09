package exam01;

//재귀방식으로 만든 계산기 코딩
public class RecCalculator implements Calculator {
    @Override
    public long factorial(long num) {

        if (num > 1L) {
            return 1L;
        }
        return num * factorial(num - 1);
    }
}
