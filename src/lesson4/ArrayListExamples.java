package lesson4;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExamples {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>(100);
        integerArrayList.add(123);
        integerArrayList.add(321);
        integerArrayList.add(123);
        integerArrayList.add(345);

        System.out.println(integerArrayList);

        integerArrayList.remove(new Integer(123));
        System.out.println(integerArrayList);

        System.out.println(integerArrayList.size());

        integerArrayList.set(0, new Integer(123));
        System.out.println(integerArrayList);

        integerArrayList.add(1, 888);
        System.out.println(integerArrayList);

        ArrayList<Integer> integerArrayList1 = new ArrayList<>(Arrays.asList(123, 234, 345));
        System.out.println(integerArrayList1);

        System.out.println(integerArrayList1.contains(new Integer(234)));
        //integerArrayList1.remove(new Integer(234));

        integerArrayList.removeAll(integerArrayList1);
        System.out.println(integerArrayList);

        integerArrayList.addAll(integerArrayList1);
        System.out.println(integerArrayList);

    }
}
