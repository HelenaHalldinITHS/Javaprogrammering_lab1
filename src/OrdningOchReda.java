import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.*;

public class OrdningOchReda {
    private static Scanner scanner = new Scanner(System.in);
    private static final int AMOUNT_OF_NUMBERS = 5;
    private static int[] input = new int[AMOUNT_OF_NUMBERS];
    private static int[] sortedInput;

    public static void run() {
        printWelcomeMessage();
        getInput();
        printResult();
    }
    
    private static void printWelcomeMessage() {
        System.out.println("Välkommen till spelet \"Ordning och reda\"! ");
    }

    private static void getInput() {
        System.out.println("Skriv 5 tal, separerade med mellanslag: ");
        String inputAsString = scanner.nextLine();
        changeFormOfInput(inputAsString);
    }

    private static void changeFormOfInput(String inputAsString) {
        String[] inputAsStringArray = splitStringAtSpace(inputAsString);
        input = getIntArrayFromStringArray(inputAsStringArray);
    }

    private static String[] splitStringAtSpace(String inputAsString) {
        return inputAsString.split(" ");

    }

    private static int[] getIntArrayFromStringArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = parseInt(stringArray[i]);
        }
        return intArray;
    }

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

    private static void getInputInSortedForm() {
        sortedInput = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedInput);
    }

    private static boolean isInputSorted() {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != sortedInput[i])
                return false;
        }
        return true;
    }

    private static int sumOfSecondGreatestAndSecondLeast(int[] sortedArray) {
        return (sortedArray[1] + sortedArray[sortedArray.length - 2]);
    }
}