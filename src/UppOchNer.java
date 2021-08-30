import java.util.Arrays;
import java.util.Scanner;

public class UppOchNer {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        printWelcomeMessage();

        String[] words = getInput();
        printUppAndDown(words);
    }

    private static void printWelcomeMessage(){
        System.out.println("Välkommen till spelet \"Upp och Ner\"! ");
    }

    private static String[] getInput(){
        int maxNumberOfWords = 10;
        String[] words = initializeEmptyString(maxNumberOfWords);

        for (int i = 0; i < 10; i++) {
            System.out.println("Skriv ett ord(Avsluta med \"END\", max antal ord är " + maxNumberOfWords + "): ");
            String tempString = scanner.nextLine();
            if (tempString.equals("END")) {
                break;
            } else
                words[i] = tempString;
        }

        return words;
    }

    //Initialisera en array med tomma strängar.
    private static String[] initializeEmptyString(int maxNumberOfWords) {
        String[] words = new String[maxNumberOfWords];
        Arrays.fill(words, ""); //inizialize array words with empty strings.
        return words;
    }

    //Skriv ut resultatet från spelet.
    private static void printUppAndDown(String[] words) {
        printStringArrayBackwards(words); //Skriv ut baklänges
        System.out.println("END"); //Skriv ut END
        printStringArray(words); //Skriv ut i "vanlig" ordning
        System.out.println(); //Avsluta med en tom rad.
    }

    private static void printStringArray(String[] words) {
        for (String word : words) {
            if (!word.isEmpty())
                System.out.println(word);
        }
    }

    private static void printStringArrayBackwards(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!words[9 - i].isEmpty())
                System.out.println(words[9 - i]);
        }
    }

}
