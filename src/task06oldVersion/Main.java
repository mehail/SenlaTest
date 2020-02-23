/**
 * Имеется набор вещей, которые необходимо поместить в рюкзак.
 * Рюкзак обладает заданной грузоподъемностью.
 * Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
 * Цель задачи заполнить рюкзак не превысив его грузоподъемность и
 * максимизировать суммарную ценность груза.
 */

package task06oldVersion;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Input the carrying capacity of the knapsack: ");
            int carrying = scanner.nextInt();
            if (carrying <= 0) {
                throw new InputMismatchException();
            }

            System.out.print("Input the number of things to generate: ");
            int numberThings = scanner.nextInt();
            if (numberThings <= 0) {
                throw new InputMismatchException();
            }

            Thing thing = new Thing();
            List<Thing> generatedThingsList = thing.generate(numberThings, carrying);
            Knapsack knapsack = new Knapsack(carrying);
            knapsack.packer(generatedThingsList);

        } catch (InputMismatchException e) {
            System.out.println("Oops! You input an incorrect value.");
        }

        scanner.close();
    }
}