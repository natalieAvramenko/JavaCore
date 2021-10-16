package lesson9.homeWork9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Petr", Arrays.asList(new Course("Math"),
                new Course("Information Technology"), new Course("Testing"))));
        students.add(new Student("Kirill", Arrays.asList(new Course("Physics"),
                new Course("Testing"), new Course("Programming"),
                new Course("Math"))));
        students.add(new Student("Zhanna", Arrays.asList(new Course("Psychology"),
                new Course("Math"), new Course("Biology"),
                new Course("Information Security"))));

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        Course course = new Course("Math");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
