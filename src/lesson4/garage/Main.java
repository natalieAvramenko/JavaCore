package lesson4.garage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> garage = new ArrayList<>();

        Bike bike = new Bike("Java", 20);
        Car car = new Car("Opel", 180);

        garage.add(bike);
        garage.add(car);

        Car car1 = new Car("BMW", 200);
        garage.add(car1);

        Collections.sort(garage);
        System.out.println(garage);

        ArrayList<Car> carArrayList = new ArrayList<>(Arrays.asList(new Car("Opel", 180, 12),
                new Car("BMW", 200, 15), new Car("LADA", 80, 8)));

        Collections.sort(carArrayList, new CarComparatorByValue());
        System.out.println(carArrayList);
        Collections.reverse(carArrayList);
        System.out.println(carArrayList);

    }
}
