package task02;

public class NumberUtils {

    public static int gcd(int number1, int number2) {
        if (number1 != 0 && number2 == 0)
            return Math.abs(number1);
        else
            return gcd(number2, number1 % number2);
    }

    public static int lcm(int number1, int number2) {
        return Math.abs(number1 * number2) / gcd(number1, number2);
    }

}
