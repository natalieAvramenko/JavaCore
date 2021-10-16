package lesson5;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String surname;
    private int age;
    private transient String bankCard = "1123 3322 4443 2222";
    private String patronycName;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student(String name, String surname, int age, String bankCard, String patronycName) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bankCard = bankCard;
        this.patronycName = patronycName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " " + surname + " " + age + " " + bankCard;
    }
}
