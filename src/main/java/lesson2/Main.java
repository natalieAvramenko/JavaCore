package lesson2;

public class Main {
    public static void main(String[] args) {
        //int a = 1 / 0;
        test();


    }



    public static void test() {
        test1();
    }
    public static void test1() {
        test2();
    }
    public static void test2() {
        //int a = 1 / 0;
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (StackTraceElement e : elements) {
            System.out.println(e.getClassName() + " " + e.getMethodName() + " " + e.getLineNumber());
        }
    }
}
