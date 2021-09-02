import java.util.Scanner;

public class MinMax {
    static Scanner scanner = new Scanner(System.in);
    static int max = 0;
    static int min = 0;
    static final int AMOUNT_OF_NUMBERS = 5;

    public static void run() {
        printWelcomeMessage();
        findMinAndMax();
        printResult();

    }

    private static void printWelcomeMessage() {
        System.out.println("Välkommen till spelet \"Min Max\"! ");
    }

    private static void findMinAndMax() {
        System.out.println("Skriv 5 tal, tryck enter mellan varje tal: ");

        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            updateMaxAndMin(getInput(), i);
        }
    }

    private static void updateMaxAndMin(int temp, int i) {
        if (i == 0) {
            min = temp;
            max = temp;
        } else if (temp > max)
            max = temp;
        else if (temp < min)
            min = temp;
    }

    private static int getInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printResult() {
        System.out.println("Största värdet är " + max + " och minsta värdet är " + min);
        System.out.println();
    }

}
