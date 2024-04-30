package exam04;

import java.util.Stack;

public class Ex02 {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("이름1");
        names.push("이름2");
        names.push("이름3");
        System.out.println(names.pop()); //이름 3번이 나올 것 스택구조라 맨 나중에것이 먼저
        System.out.println(names.pop()); //이름 2번
        System.out.println(names.pop()); //이름 1번
    }
}
