import java.util.Arrays;
import java.util.Scanner;

public class UppOchNer {
    static Scanner scanner = new Scanner(System.in);
    static final int MAX_NUMBER_OF_WORDS = 10;
    static String[] words = new String[MAX_NUMBER_OF_WORDS];

    public static void run() {
        printWelcomeMessage();
        resetArray();
        getWordsFromUser();
        printUppAndDown();
    }

    private static void printWelcomeMessage() {
        System.out.println("Välkommen till spelet \"Upp och Ner\"! ");
    }

    //Get all words from the user
    private static void getWordsFromUser() {
        for (int i = 0; i < words.length; i++) {
            String tempString = getInput();
            if (tempString.equals("END"))
                break;
            words[i] = tempString;
        }
    }

    //Empty the array (if first time playing, it initializes the array instead)
    private static void resetArray() {
        Arrays.fill(words, ""); //initialize / make empty
    }

    //Get each input from the user
    private static String getInput() {
        System.out.println("Skriv ett ord(Avsluta med \"END\", max antal ord är " + MAX_NUMBER_OF_WORDS + "): ");
        return scanner.nextLine();
    }


    //Skriv ut resultatet från spelet.
    private static void printUppAndDown() {
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty())
                System.out.println(words[i]);
        }
        System.out.println(); //Avsluta med en tom rad.
    }
}
