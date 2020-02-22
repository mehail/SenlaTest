/**
 * Создать программу, которая будет сообщать, является ли целое число,
 * введенное пользователем, чётным или нечётным, простым или составным.
 * Если пользователь введёт не целое число, то сообщать ему об ошибке.
 */

package task01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a number: ");

        try {
            int num = scanner.nextInt();
            System.out.println("Your number: " + num + " is " + evenOrOdd(num) + " and " + primeOrComposite(num));
        } catch (InputMismatchException e) {
            System.out.println("Oops! You entered an incorrect value.");
        }

        scanner.close();
    }

    public static String evenOrOdd(int num) {
        if (num % 2 == 0)
            return "even";
        else
            return "odd";
    }

    public static String primeOrComposite(int num) {
        String result = "prime";
        num = Math.abs(num);

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                result = "composite";
                break;
            }
        }
        return result;
    }
}