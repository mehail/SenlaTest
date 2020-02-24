/**
 * Создать программу, которая будет:
 * - подсчитывать количество слов в предложении
 * - выводить их в отсортированном виде
 * - делать первую букву каждого слова заглавной.
 * Предложение вводится вручную. (Разделитель пробел (“ ”)).
 */

package task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Input the sentence:");
            final String input = bufferedReader.readLine();
            final List<String> words = split(input);
            final String sentence = String.join(" ", words);
            int count = words.size();

            final String output = String.format("Sorted sentence: %s\nWords count: %d", sentence, count);
            System.out.println(output);

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Oops! The sentence to be checked cannot be empty");
        }
    }

    private static List<String> split(String sentence) {
        return Arrays
                .stream(sentence.split(" "))
                .filter(word -> !word.isEmpty())
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .sorted()
                .collect(Collectors.toList());
    }

}
