package exam02;

public enum Transportation {
    BUS(1350) {
        public int getTotal(int person) {
            return getFare() * person;
        }
    },
    SUBWAY(1450) {
        public int getTotal(int person) {
            return getFare() * person;
        }
    },
    TAXI(4800) {
        public int getTotal(int person) {
            return getFare() * person;
        }
    };
//위에 생성자를 외부로 출력시킨다(?)

    private final int fare;

    Transportation(int fare) {
    this.fare = fare;
    }
    public int getFare() {
        return fare;


    }

    public abstract int getTotal( int person);
}