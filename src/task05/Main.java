/**
 * Создать программу, которая в последовательности от 0 до N,
 * находит все числа-палиндромы (зеркальное значение равно оригинальному).
 * Длина последовательности N вводится вручную и не должна превышать 100.
 */

package task05;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input the length of the sequence N: ");
            final int number = scanner.nextInt();

            if (number < 0 || number > 100) {
                throw new InputMismatchException("Oops! The sequence length is outside the range from 0 to 100.");
            }

            final List<Integer> list = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                if (isPalindrome(String.valueOf(i))) {
                    list.add(i);
                }
            }

            final String output = String.format("Palindrome numbers in the sequence from 0 to %d: %s", number,
                    list.toString().replaceAll("\\[|\\]", ""));
            System.out.println(output);
        } catch (InputMismatchException e) {
            if (e.getMessage() == null)
                System.out.println("Oops! You entered an incorrect value.");
            else
                System.out.println(e.getMessage());
        }
    }

    public static boolean isPalindrome(String number) {
        StringBuilder revers = new StringBuilder(number).reverse();
        return number.equals(revers.toString());
    }

}
