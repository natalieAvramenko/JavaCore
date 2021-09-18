package lesson4;

import java.util.*;

public class Cat implements Comparable<Cat> {
    private String name;
    private int age;
    private int weight;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                "}'";
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age &&
                Objects.equals(name, cat.name);
    }
    public static void main(String[] args) {
        Cat cat1 = new Cat("Test", 1, 3);
        Cat cat2 = new Cat("Test", 2, 4);
        Cat cat3 = new Cat("Test2", 1, 101);
        Cat cat4 = new Cat("Test2", 7, 100);

        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
        System.out.println(cat3.hashCode());
        System.out.println(cat4.hashCode());

        HashSet<Cat> catHashSet = new HashSet<>(Arrays.asList(cat1, cat2, cat3, cat4));
        System.out.println(catHashSet);

        catHashSet.add(cat1);
        System.out.println(catHashSet);

        Arrays.sort(new HashSet[] {catHashSet});
        System.out.println(catHashSet);

        HashSet<Integer> integerHashSet = new HashSet<>(Arrays.asList(1, 3, 5, 7, 22, 4, 1, 6));
        System.out.println(integerHashSet);
        LinkedHashSet<Integer> integerLinkedHashSet = new LinkedHashSet<>(Arrays.asList(1, 3, 5, 6, 7, 22, 4, 1, 6));
        System.out.println(integerLinkedHashSet);

        TreeSet<Cat> catTreeSet = new TreeSet<>(new CatComparatorByWeight());
        catTreeSet.add(cat1);
        catTreeSet.add(cat2);
        catTreeSet.add(cat3);
        catTreeSet.add(cat4);

        System.out.println(catTreeSet);


    }


    @Override
    public int compareTo(Cat o) {
        return o.getAge() - age;
    }
}
