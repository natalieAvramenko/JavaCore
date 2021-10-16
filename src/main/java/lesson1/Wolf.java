package lesson1;

public class Wolf extends Animal implements CanSwim {
    private int swimmingSpeed;

    public Wolf(String name, String color, int age) {
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
        System.out.println("Волк воет на луну!");
    }

    public double swim(Pool pool) {
        System.out.println("Волк плавает!");
        System.out.println("Затратил " + pool.getLength() / swimmingSpeed);
        return pool.getLength() / swimmingSpeed;
    }
}