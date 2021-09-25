package lesson5.homeWork5;

import java.io.Serializable;

public class Car implements Serializable {
    private String carBrand;
    private String carModel;
    private int yearOfIssue;
    private int power;

    public Car(String carBrand, String carModel, int yearOfIssue, int power) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.yearOfIssue = yearOfIssue;
        this.power = power;
    }

    public Car(String carBrand, String carModel, int yearOfIssue) {

    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }


    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return carBrand + " ; " + carModel + " ; " + yearOfIssue + " ; " + power;
    }
}
