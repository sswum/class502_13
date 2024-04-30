package exam05;
//▼컴파일 입장에선 명확하게 다 정리가 돼야하는데 지금 여기서 있는 T가 다 형식상 오류라고 생각해 컴파일 할 때 다 제거함.

public class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item= item;

    }

    public T getItem() {

        return item;
    }
}
