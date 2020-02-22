package task01;

public class NumberUtils {

    public static NumberProperty evenOrOdd(int num){
        return num % 2 == 0 ? NumberProperty.EVEN : NumberProperty.ODD;
    }

    public static NumberProperty primeOrComposite (int num){
        for (int i = 2; i <= Math.abs(num) / 2; i++) {
            if (num % i == 0) {
                return NumberProperty.COMPOSITE;
            }
        }
        return NumberProperty.PRIME;
    }

}
