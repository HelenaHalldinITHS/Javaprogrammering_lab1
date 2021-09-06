import java.util.Arrays;
import java.util.Scanner;

public class UppOchNer {
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_NUMBER_OF_WORDS = 10;
    private static String[] words = new String[MAX_NUMBER_OF_WORDS];

    //Styr körning av applikationen. Klassens enda metod som kan anropas utifrån.
    public static void run() {
        printWelcomeMessage();
        resetArray();
        getWordsFromUser();
        printUppAndDown();
    }

    //Skriver ut välkomstmeddelande
    private static void printWelcomeMessage() {
        System.out.println("Välkommen till spelet \"Upp och Ner\"! ");
    }

    //Initierar den array som ska sparar de ord som användaren anger.
    //(Om det inte är första gången applikationen körs töms tidigare sparade ord)
    private static void resetArray() {
        Arrays.fill(words, ""); //initialize / make empty
    }


    //Hämtar ord från användaren och sparar dessa
    private static void getWordsFromUser() {
        for (int i = 0; i < words.length; i++) {
            String tempString = getInput();
            if (tempString.equals("END"))
                break;
            words[i] = tempString;
        }
    }

    //Hämtar input från användaren
    private static String getInput() {
        System.out.println("Skriv ett ord(Avsluta med \"END\", max antal ord är " + MAX_NUMBER_OF_WORDS + "): ");
        return scanner.nextLine();
    }

    //Skriv ut resultatet för applikationen
    private static void printUppAndDown() {
        for (int i = words.length - 1; i >= 0; i--) {
            printIfNotEmptyString(words[i]);
        }
        System.out.println();
    }

    //Skriver ut strängen om den inte är tom
    private static void printIfNotEmptyString(String word) {
        if (!word.isEmpty())
            System.out.println(word);
    }
}
