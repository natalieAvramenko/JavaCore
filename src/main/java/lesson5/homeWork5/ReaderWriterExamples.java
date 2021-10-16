package lesson5.homeWork5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReaderWriterExamples {
    public static void main(String[] args) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("car.txt"), StandardCharsets.UTF_8)) {
            int x;
            while ((x = inputStreamReader.read()) != -1) {
                System.out.println(x);
                System.out.println((char)x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("car.txt"))) {
            System.out.println(bufferedReader.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Car> cars = new ArrayList<>();

        String tempString;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("cars.txt"))) {
            while ((tempString = bufferedReader.readLine()) != null) {
                String[] carParametersArray = tempString.split(" ");
                cars.add(new Car(carParametersArray[0], carParametersArray[1],
                        Integer.parseInt(carParametersArray[4])));
            }
            System.out.println(cars);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter printWriter = new PrintWriter("new_cars.csv")) {
            for (Car car : cars) 
                printWriter.println(car.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
