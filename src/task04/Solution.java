/**
 * Создать программу, которая подсчитывает сколько
 * раз употребляется слово в тексте (без учета регистра).
 * Текст и слово вводится вручную.
 */

package task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        String msgError = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input the text:");
            String str = bufferedReader.readLine();
            if (str.equals("")) {
                msgError = "Oops! The text to be checked cannot be empty.";
                throw new InputMismatchException();
            }

            System.out.println("input the word to count:");
            String word = bufferedReader.readLine().replaceAll(" ", "");
            if (word.equals("")) {
                msgError = "Oops! The search word cannot be empty.";
                throw new InputMismatchException();
            }

            String[] subStr = str.split(" ");

            int count = 0;
            for (String s : subStr) {
                if (word.toLowerCase().equals(s.toLowerCase()))
                    count++;
            }

            System.out.println("The word \"" + word + "\" is repeated " + count + " times in the text.");

            bufferedReader.close();

        } catch (Exception e) {
            if (msgError != null)
                System.out.println(msgError);
            else
                e.printStackTrace();
        }
    }
}