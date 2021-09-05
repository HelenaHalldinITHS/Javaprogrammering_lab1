import java.util.Scanner;

public class MinMax {
    private static Scanner scanner = new Scanner(System.in);
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static final int AMOUNT_OF_NUMBERS = 5;

    public static void run() {
        printWelcomeMessage();
        findMinAndMax();
        printResult();
        resetMinAndMax();
    }

    private static void printWelcomeMessage() {
        System.out.println("Välkommen till spelet \"Min Max\"! ");
    }

    private static void findMinAndMax() {
        System.out.println("Skriv 5 tal, tryck enter mellan varje tal: ");

        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            updateMaxAndMin(getInput());
        }
    }

    private static void updateMaxAndMin(int temp) {
        if (temp > max)
            max = temp;
        if (temp < min)
            min = temp;
    }

    private static int getInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printResult() {
        System.out.println("Största värdet är " + max + " och minsta värdet är " + min);
        System.out.println();
    }

    private static void resetMinAndMax() {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
}
