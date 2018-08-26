package habitat.data;

public class Tupple<E, F> {

    private E value1;
    private F value2;

    public Tupple(E value1, F value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public E getValue1() {
        return value1;
    }

    public void setValue1(E value1) {
        this.value1 = value1;
    }

    public F getValue2() {
        return value2;
    }

    public void setValue2(F value2) {
        this.value2 = value2;
    }
}
