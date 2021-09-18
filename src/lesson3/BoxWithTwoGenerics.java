package lesson3;

public class BoxWithTwoGenerics<T, S> {
    private T object1;
    private S object2;

    public BoxWithTwoGenerics(T object1, S object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public T getObject1() {
        return object1;
    }

    public void setObject1(T object1) {
        this.object1 = object1;
    }

    public S getObject2() {
        return object2;
    }

    public void setObject2(S object2) {
        this.object2 = object2;
    }

    public static void main(String[] args) {
        BoxWithTwoGenerics<Integer, String> integerStringBoxWithTwoGenerics = new BoxWithTwoGenerics(145000000, "Население России");
        System.out.println(integerStringBoxWithTwoGenerics.getObject1() + " " + integerStringBoxWithTwoGenerics.getObject2());

    }
}


