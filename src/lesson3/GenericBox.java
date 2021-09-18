package lesson3;

import java.sql.Array;
import java.util.ArrayList;

public class GenericBox <T> {
    private T object;

    public GenericBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "GenBox{" +
                "object=" + object +
                '}';
    }

    public static void main(String[] args) {
        GenericBox<Integer> genBox1 = new GenericBox<>(5);
        GenericBox<Integer> genBox2 = new GenericBox<>(10);

        int sum = genBox1.getObject() + genBox2.getObject();

        GenericBox<String> genBox3 = new GenericBox<>("Test");

        //int sum2 = genBox1.getObject() + genBox3.getObject();


        Integer a = 1;
        Number b = a;

        ArrayList<Integer> aList = new ArrayList<>(1);
       // ArrayList<Number> nList = aList;

        GenericBox box = new GenericBox(11);

        }

}





