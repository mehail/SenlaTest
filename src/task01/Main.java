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
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input a number: ");
            final int input = scanner.nextInt();

            final NumberProperty evenOrOdd = NumberUtils.evenOrOdd(input);
            final NumberProperty primeOrComposite = NumberUtils.primeOrComposite(input);

            final String output = String.format("Your number: %d is %s and %s", input, evenOrOdd.getTitle(),
                    primeOrComposite.getTitle());

            System.out.println(output);
        } catch (InputMismatchException e) {
            System.out.println("Oops! You entered an incorrect value.");
        }
    }

}