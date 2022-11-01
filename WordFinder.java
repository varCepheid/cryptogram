import java.util.Scanner;

public class WordFinder {
  public static void findWords(String[] wordlist, Scanner inputSc) {
    System.out.println("Enter a string of numbers, where each different number is a different letter.");
    String inputString = inputSc.next();
    int[] input = new int[inputString.length()];
    for (int i = 0; i < inputString.length(); i++) {
      input[i] = Integer.parseInt(inputString.substring(i, i + 1));
    }

    for (String word : wordlist) {
      if (word.length() != input.length) {
        continue;
      }

      boolean wordWorks = true;
      String wordLetters = "          ";

      for (int i = 0; i < word.length(); i++) {
        char letter = word.charAt(i);
        int letterIndex = input[i];

        if (!(wordLetters.charAt(letterIndex) == letter)) {
          if (wordLetters.charAt(letterIndex) == ' ' && wordLetters.indexOf(letter) == -1) {
            wordLetters = wordLetters.substring(0, letterIndex) + letter + wordLetters.substring(letterIndex + 1);
          } else {
            wordWorks = false;
            break;
          }
        }
      }

      if (wordWorks) {
        System.out.println(word);
      }
    }

    findWords(wordlist, inputSc);
  }
}