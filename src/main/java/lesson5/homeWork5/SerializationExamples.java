package lesson5.homeWork5;

import java.io.*;


public class SerializationExamples {
    public static void main(String[] args) {
        File cars = new File("new_cars.csv");


        Car car = new Car("Audi", "Q7", 2020, 180);
        Car car1 = new Car("BMW", "X5", 2021, 250);
        Car car2 = new Car("Toyota", "Corola", 2019, 160);
        Car car3 = new Car("Lada", "Priora", 2018, 100);


//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(cars))) {
//            objectOutputStream.writeObject(car);
//            objectOutputStream.writeObject(car1);
//            objectOutputStream.writeObject(car2);
//            objectOutputStream.writeObject(car3);
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(cars));
            Car carFromFile = (Car) objectInputStream.readObject();
            System.out.println(carFromFile);
            Car carFromFile1 = (Car) objectInputStream.readObject();
            System.out.println(carFromFile1);
            Car carFromFile2 = (Car) objectInputStream.readObject();
            System.out.println(carFromFile2);
            Car carFromFile3 = (Car) objectInputStream.readObject();
            System.out.println(carFromFile3);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

