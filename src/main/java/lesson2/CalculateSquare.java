package lesson2;

public class CalculateSquare {

    public static void main(String[] args) {

        try {
            int square = calcRectangleSquare(-1, 9);
        } catch (OneOrBothSidesAreNegativeException e) {
            e.printStackTrace();
        }

    }

    private static int calcRectangleSquare(int sideA, int sideB) throws OneOrBothSidesAreNegativeException {
        if (sideA <= 0 || sideB <= 0) {
            throw new OneOrBothSidesAreNegativeException("Сторона отрицательная!");
        }
        return sideA * sideB;

    }

}
