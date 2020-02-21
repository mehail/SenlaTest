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

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input the sentence:");
            String str = bufferedReader.readLine();
            str = str.replaceAll("\\s{2,}", " ");

            String[] subStr = str.split(" ");
            Arrays.sort(subStr);

            for (String word : subStr) {
                System.out.println(word.substring(0, 1).toUpperCase() + word.substring(1));
            }

            System.out.println("Count word: " + subStr.length);

            bufferedReader.close();

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Oops! The sentence to be checked cannot be empty");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}