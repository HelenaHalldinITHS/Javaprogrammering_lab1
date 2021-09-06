import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.*;

public class OrdningOchReda {
    private static Scanner scanner = new Scanner(System.in);
    private static final int AMOUNT_OF_NUMBERS = 5;
    private static int[] input = new int[AMOUNT_OF_NUMBERS];
    private static int[] sortedInput;

    //Styr körning av applikationen. Klassens enda metod som kan anropas utifrån.
    public static void run() {
        printWelcomeMessage();
        getInput();
        printResult();
    }

    //Skriver ut välkomstmeddelande
    private static void printWelcomeMessage() {
        System.out.println("Välkommen till spelet \"Ordning och reda\"! ");
    }

    //Hämtar input från användaren
    private static void getInput() {
        System.out.println("Skriv 5 tal, separerade med mellanslag: ");
        String inputAsString = scanner.nextLine();
        changeFormOfInput(inputAsString);
    }

    //Ser till att inputen lagras i önskat format (int[])
    private static void changeFormOfInput(String inputAsString) {
        String[] inputAsStringArray = splitStringAtSpace(inputAsString);
        input = getIntArrayFromStringArray(inputAsStringArray);
    }

    //Separerar en sträng där mellanslag förekommer och lagrar dessa separerade "ord" i en String[]
    private static String[] splitStringAtSpace(String inputAsString) {
        return inputAsString.split(" ");

    }

    //Konverterar en String[] till en int[]
    private static int[] getIntArrayFromStringArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = parseInt(stringArray[i]);
        }
        return intArray;
    }

    //Skriver ut resultatet för applikationen
    private static void printResult() {
        getInputInSortedForm();

        System.out.println("Min value: " + sortedInput[0]);
        System.out.println("2Min value: " + sortedInput[1]);
        System.out.println("2Max value: " + sortedInput[sortedInput.length - 2]);
        System.out.println("Max value: " + sortedInput[sortedInput.length - 1]);
        System.out.println("I ordning: " + isInputSorted());
        System.out.println("Summa: " + sumOfSecondGreatestAndSecondLeast(sortedInput));
        System.out.println();
    }

    // Skapar en int[] som innehåller input (talen) i en sorterad ordning
    private static void getInputInSortedForm() {
        sortedInput = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedInput);
    }

    //Kollar om användaren angivit input (talen) i ordning (dvs minst till störst)
    private static boolean isInputSorted() {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != sortedInput[i])
                return false;
        }
        return true;
    }

    //Ger summan av det näst största och näst minsta talet i en sorterad int[]
    private static int sumOfSecondGreatestAndSecondLeast(int[] sortedArray) {
        return (sortedArray[1] + sortedArray[sortedArray.length - 2]);
    }
}