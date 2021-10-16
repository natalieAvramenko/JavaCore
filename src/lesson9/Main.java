package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Oleg", 29, Person.Position.ENGINEER));
        personList.add(new Person("Anton", 54, Person.Position.MANAGER));
        personList.add(new Person("Oksana", 34, Person.Position.MANAGER));
        personList.add(new Person("Aleksey", 25, Person.Position.ENGINEER));
        personList.add(new Person("Andrey", 41, Person.Position.DIRECTOR));
        personList.add(new Person("Elena", 22, Person.Position.ENGINEER));

        //выбрать инженеров и отсортировать их по возрасту
        System.out.println(personList.stream()
                .filter(p -> p.getPosition() == Person.Position.ENGINEER)
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .collect(Collectors.toList()));

        Optional<Integer> sumAges = personList.stream()     //поток людей
                .map(p -> p.getAge())       //поток возрастов
                .reduce((p1, p2) -> p1 + p2);
        if (sumAges.isPresent()) System.out.println("Всё получилось!");

        Stream<Integer> integerOptional = Stream.of();
        Optional<Integer> sumInt = integerOptional.reduce((p1, p2) -> p1 + p2);

        if (sumInt.isPresent()) System.out.println("Посчитали" + sumInt.get());

        Stream.of("1234", "1234", "1234", "4567")
                .distinct()
                .forEach(System.out :: println);

        Stream.of("1234", "1234", "1234", "4567")
                .collect(Collectors.toSet());

        Integer[][] ints = new Integer[][]{{1, 2, 3}, {4, 5, 6}};
        Stream.of(ints)
                .flatMap(a -> Stream.of(a))
                .forEach(System.out :: println);

    }
}

