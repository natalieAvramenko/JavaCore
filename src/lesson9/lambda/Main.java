package lesson9.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Рыба", false, false));
        animalList.add(new Animal("Кот", true, true));
        animalList.add(new Animal("Лягушка", false, true));
        animalList.add(new Animal("Черепаха", true, false));

        //printAnimals(animalList, new CheckIsJumper());

        printAnimal(animalList, new CheckAble() {
            @Override
            public boolean test(Animal animal) {
                return  animal.isCanJump();
//                return animal.isCanRun();//анонимный класс
            }
        });

        printAnimal(animalList, a -> a.isCanRun()); //укороченный вариант
    }

    private static void printAnimal(List<Animal> animalList, CheckAble checkAble) {
        for (Animal animal : animalList) {
            if (checkAble.test(animal)) {
                System.out.println(animal);
            }
        }
    }

}
