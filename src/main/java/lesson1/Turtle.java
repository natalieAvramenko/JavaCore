package lesson1;

public class Turtle extends Animal implements CanSwim {
    private int swimmingSpeed;

    public Turtle(String name, String color, int age, int swimmingSpeed) {
        super(name, color, age);
        this.swimmingSpeed = swimmingSpeed;
    }

    public Turtle(String name, String color, int age) {
        super(name, color, age);
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public void voice() {
        System.out.println("Черепаха звучит!");
    }

    public double swim(Pool pool) {
        System.out.println("Черепаха плавает!");
        System.out.println("Затратил " + pool.getLength() / swimmingSpeed);
        return pool.getLength() / swimmingSpeed;
    }
}
