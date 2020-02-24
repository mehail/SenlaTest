/**
 * Создать программу, которая подсчитывает сколько
 * раз употребляется слово в тексте (без учета регистра).
 * Текст и слово вводится вручную.
 */

package task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Input the text:");
            final String text = bufferedReader.readLine();

            if (text.isEmpty()) {
                throw new InputMismatchException("Oops! The text to be checked cannot be empty.");
            }

            System.out.println("input the word to count:");
            final String word = bufferedReader.readLine();

            if (word.isEmpty()) {
                throw new InputMismatchException("Oops! The search word cannot be empty.");
            }

            final List<String> words = split(text);
            final int count = Collections.frequency(words, word.toLowerCase());

            final String output = String.format("The word \"%s\" is repeated %d times in the text.", word, count);
            System.out.println(output);

        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }

    private static List<String> split(String sentence) {
        return Arrays
                .stream(sentence.split(" "))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
