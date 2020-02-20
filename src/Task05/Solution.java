/**
 * Создать программу, которая в последовательности от 0 до N,
 * находит все числа-палиндромы (зеркальное значение равно оригинальному).
 * Длина последовательности N вводится вручную и не должна превышать 100.
 */

package Task05;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the length of the sequence N: ");

        try {
            int n = scanner.nextInt();
            if (n < 0 || n > 100) {
                throw new InputMismatchException();
            }

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (isPalindrome(String.valueOf(i))) {
                    list.add(i);
                }
            }

            System.out.println("Palindrome numbers in the sequence from 0 to " + n + ": ");
            for (int output : list) {
                System.out.print(output + " ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Oops! You entered an incorrect value. " +
                                "The sequence length is outside the range from 0 to 100.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String num) {
        StringBuilder revers = new StringBuilder(num).reverse();
        return num.equals(revers.toString());
    }
}