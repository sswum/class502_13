package exam05;

public class Ex01 {
    public static void main(String[] args) {
        SimpleCalculator cal = new SimpleCalculator();
        int result = cal.add(10,20);
        System.out.println(result);

        System.out.println(cal.num);
//calcurator가 아까 완전한 객체가 아니라고 했는데 (완전히 구현하지 않앗기때문에)
        //add가 약간 미완성적인걸 좀 다듬어서 객체로 만듦
    }
}
