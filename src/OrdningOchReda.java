import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.*;

public class OrdningOchReda {
    private static Scanner scanner = new Scanner(System.in);
    private static String inputAsString;
    private static int[] input = new int[5];
    private static int[] sortedInput;

    public static void run() {
        printWelcomeMessage();
        getInput();
        getInputInSortedForm();
        printEndMessage();
    }

    private static void printWelcomeMessage() {
        System.out.println("Välkommen till spelet \"Ordning och reda\"! ");
    }

    private static void getInput() {
        System.out.println("Skriv 5 tal, separerade med mellanslag: ");
        inputAsString = scanner.nextLine();
        changeFormOfInput();
    }

    private static void changeFormOfInput() {
        StringBuilder tempString = new StringBuilder();
        char temp;
        int counter = 0;

        for (int i = 0; i < inputAsString.length(); i++) {
            temp = inputAsString.charAt(i);
            if (temp == ' ') {
                flushData(tempString, counter++);
                emptyEntireString(tempString);
            } else
                tempString.append(temp);
            if (isLastRound(i)) {
                flushData(tempString, counter);
            }
        }
    }

    private static void emptyEntireString(StringBuilder tempString) {
        tempString.delete(0, tempString.length()); //nollställ
    }

    private static void flushData(StringBuilder tempString, int counter) {
        input[counter] = parseInt(tempString.toString());
    }

    private static boolean isLastRound(int i) {
        return i == (inputAsString.length() - 1);
    }

    private static int sumOfSecondGreatestAndSecondLeast() {
        return (sortedInput[1] + sortedInput[sortedInput.length - 1]);
    }

    private static boolean isInputSorted() {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != sortedInput[i])
                return false;
        }
        return true;
    }

    private static void getInputInSortedForm() {
        sortedInput = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedInput);
    }

    private static void printEndMessage() {
        System.out.println("Min value: " + sortedInput[0]);
        System.out.println("2Min value: " + sortedInput[1]);
        System.out.println("2Max value: " + sortedInput[sortedInput.length - 2]);
        System.out.println("Max value: " + sortedInput[sortedInput.length - 1]);
        System.out.println("I ordning: " + isInputSorted());
        System.out.println("Summa: " + sumOfSecondGreatestAndSecondLeast());
        System.out.println();
    }
}