package lesson2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ALotOfExceptions {
    public static void main(String[] args) {

        try {
            int a = 1 / 0;
            test();

            InputStream inputStream = new FileInputStream("test.txt");

        } catch (FileNotFoundException e)
        {
            System.out.println("файл не найден");
        }
        catch (ArithmeticException e)
        {
            System.out.println("деление на ноль");
        }
        catch (StackOverflowError e)
        {
            System.out.println("переполнение стека");
        } finally {

        }
        System.out.println("Я жив!");

    }

    public static void test() {
        test();

    }
}
