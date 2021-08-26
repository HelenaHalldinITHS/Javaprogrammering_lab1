import java.util.Arrays;
import java.util.Scanner;

public class UppOchNer {

    public static void playGame() {
        System.out.println("Välkommen till spelet \"Upp och Ner\"! ");

        String[] words = getInput();
        printUppAndDown(words);
    }

    private static String[] getInput(){
        Scanner scanner = new Scanner(System.in);
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

        //Skriv ut baklänges
        for (int i = 0; i < 10; i++) {
            if (!words[9 - i].isEmpty())
                System.out.println(words[9 - i]);
        }

        //Skriv ut END
        System.out.println("END");

        //Skriv ut i "vanlig" ordning
        for (int i = 0; i < 10; i++) {
            if (!words[i].isEmpty())
                System.out.println(words[i]);
        }

        //Avsluta med en tom rad.
        System.out.println("");
    }

}
