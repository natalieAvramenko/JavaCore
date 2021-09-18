package lesson4;

import java.util.HashMap;

public class HashMapExamples {
    public static void main(String[] args) {
        HashMap<Integer, String> passports = new HashMap<>();

        passports.put(1234, "Ann");
        passports.put(4321, "John");
        passports.put(1333, "George");
        passports.put(12224, "Kate");

        System.out.println(passports);

        for (Integer number: passports.keySet()) {
            System.out.println(number);

            passports.get(number);
        }

    }



}
