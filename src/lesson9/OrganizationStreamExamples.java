package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganizationStreamExamples {
    public static void main(String[] args) {
        List<Organization> organizationList = new ArrayList<>();

        organizationList.add(new Organization(1, "Yandex", Arrays.asList(
                new Worker("Oleg", 29, 100, "Engineer"),
                new Worker("Anton", 54,150, "Manager"),
                new Worker("Elena", 22, 140, "Engineer")
        )));

        organizationList.add(new Organization(2, "Sber", Arrays.asList(
                new Worker("Oleg", 29, 100, "Engineer"),
                new Worker("Anton", 54,150, "Manager"),
                new Worker("Elena", 22, 140, "Engineer"),
                new Worker("Andrey", 41, 400, "Director"),
                new Worker("Oksana", 34, 100, "Engineer")
        )));

        organizationList.add(new Organization(3, "Mail", Arrays.asList(
                new Worker("Zhanna", 25, 70, "Engineer"),
                new Worker("Artem", 45,350, "Manager"),
                new Worker("Ksenia", 33, 240, "Engineer")
        )));

        //Вывести список уникальных имен сотрудников, в компаниях с >3 сотрудниками
        System.out.println(organizationList.stream()
                .filter(o ->o.getWorkerList().size() >3)
                .map(o -> o.getWorkerList())
                .flatMap(w -> w.stream())
                .map(w -> w.getName())
                .collect(Collectors.toSet()));

        System.out.println(organizationList.stream()
                .map(o -> o.getWorkerList())
                .flatMap(w -> w.stream())
                .collect(Collectors.groupingBy(w -> w.getPosition())));


        Map<String, List<Worker>> workerMap = organizationList.stream()
                .map(o -> o.getWorkerList())
                .flatMap(w -> w.stream())
                .collect(Collectors.groupingBy(w -> w.getPosition()));


        Map<String, Double> salaryMap = organizationList.stream()
                .map(o -> o.getWorkerList())
                .flatMap(w -> w.stream())
                .collect(Collectors.groupingBy(w -> w.getPosition(), Collectors.averagingDouble(f -> f.getSalary())));

        System.out.println(salaryMap);


    }
}
