package lesson4.garage;

public class Vehicle implements Comparable<Vehicle> {
    protected String model;
    protected int power;

    public Vehicle(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model=" + model + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public int compareTo(Vehicle o) {
        return power - o.getPower();
    }
}
