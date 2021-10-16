package lesson4.garage;

public class Car extends Vehicle {

    private int value;

    public Car(String model, int power) {
        super(model, power);
    }

    public Car(String opel, int power, int i) {
        super(opel, power);
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
