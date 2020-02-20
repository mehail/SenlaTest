/**
 * Создать программу, которая будет вычислять и выводить на экран
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель)
 * двух целых чисел, введенных пользователем.
 * Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
 */

package Task02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("input the first number: ");
            int num1 = scanner.nextInt();
            System.out.print("input the second number: ");
            int num2 = scanner.nextInt();

            System.out.println("GCD numbers is " + gcd(num1, num2));
            System.out.println("LCM numbers is " + lcm(num1, num2));

        } catch (ArithmeticException e) {
            System.out.println("Oops! The GCD exists and is uniquely defined if at least one of the numbers is not 0.");
        } catch (InputMismatchException e) {
            System.out.println("Oops! You entered an incorrect value.");
        }

        scanner.close();
    }

    public static int gcd(int num1, int num2) {
        if (num1 != 0 && num2 == 0)
            return Math.abs(num1);
        else
            return gcd(num2, num1 % num2);
    }

    public static int lcm(int num1, int num2) {
        return Math.abs(num1 * num2) / gcd(num1, num2);
    }
}