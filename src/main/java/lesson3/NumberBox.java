package lesson3;

import java.util.Arrays;

public class NumberBox<T extends Number> {
    private T[] numbers;

    public NumberBox(T... numbers) {
        this.numbers = numbers;
    }

    public T[] getNumbers() {
        return numbers;
    }

    public void setNumbers(T[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public String toString() {
        return "NumberBox{" +
                "array=" + Arrays.toString(numbers) +
                "}";
    }

    public double calcAverage()
    {
        double sum = 0.0;

        for (T element : numbers)
        {
            sum = sum + element.doubleValue();
        }
        return  sum / numbers.length;
    }

    public boolean isSameAvg(NumberBox<?> boxToCompare) {
        return  Math.abs(this.calcAverage() - boxToCompare.calcAverage()) < 0.0001;
    }

    public static <U extends Number> U getFirstElement(NumberBox<U> numbersBox) {
        return numbersBox.getNumbers()[0];
    }

    public static void main(String[] args) {
        NumberBox<Integer> array = new NumberBox<>(1,2,3,4,5,6);

        System.out.println(array.calcAverage());

        NumberBox<Integer> array2 = new NumberBox<>(1,2,7,4,5,6);

        System.out.println(array.isSameAvg(array2));

        System.out.println(getFirstElement(array2));
    }
}
