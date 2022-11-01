import java.util.Scanner;
import java.io.File;

public class Main {
    public static final int wordlistLength = 69903;
    public static void main(String[] args) throws Exception {
        String[] wordlist = new String[wordlistLength];
        Scanner fileSc = new Scanner(new File("English wordlist.txt"));
        for (int i = 0; i < wordlistLength; i++) {
            wordlist[i] = fileSc.nextLine();
        }
        fileSc.close();

        Scanner inputSc = new Scanner(System.in);
        WordFinder.findWords(wordlist, inputSc);
        inputSc.close();
    }
}
