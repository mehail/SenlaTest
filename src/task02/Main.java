/**
 * Создать программу, которая будет вычислять и выводить на экран
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель)
 * двух целых чисел, введенных пользователем.
 * Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
 */

package task02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("input the first number: ");
            final int number1 = scanner.nextInt();
            System.out.print("input the second number: ");
            final int number2 = scanner.nextInt();

            final int gcd = NumberUtils.gcd(number1, number2);
            final int lcm = NumberUtils.lcm(number1, number2);
            final String output = String.format("GCD numbers is %s, LCM numbers is %s", gcd, lcm);
            System.out.println(output);

        } catch (ArithmeticException e){
            System.out.println("Oops! The GCD exists and is uniquely defined if at least one of the numbers is not 0.");
        } catch (InputMismatchException e){
            System.out.println("Oops! You entered an incorrect value.");
        }
    }

}