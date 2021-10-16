package lesson2;

public class UncheckedExceptions {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        try {
            int c = a / b;
        } catch (Exception e) {
            System.out.println("деление на ноль");
        }
        if (b != 0) {int c = a / b;}

    }
}
