package exam01;

public class SimpleCalculator extends  Calculator {

    public SimpleCalculator() { //생성자 함수 만들고 밑에 꼭 있어야 하는 super!
        super();
    }
    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
