import java.util.Scanner;

public class MinMax {
    private static Scanner scanner = new Scanner(System.in);
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static final int AMOUNT_OF_NUMBERS = 5;
    private static int[] input = new int[AMOUNT_OF_NUMBERS];

    //Styr körning av applikationen. Klassens enda metod som kan anropas utifrån.
    public static void run() {
        printWelcomeMessage();
        getInput();
        findMinAndMax();
        printResult();
        resetMinAndMax();
    }

    //Skriver ut välkomstmeddelande
    private static void printWelcomeMessage() {
        System.out.println("Välkommen till spelet \"Min Max\"! ");
    }

    //Hämtar input från användaren och sparar denna.
    private static void getInput() {
        System.out.println("Skriv 5 tal, tryck enter mellan varje tal: ");

        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            input[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    //Metoden avgör även vilket av dessa input som är det största resp. minsta talen
    private static void findMinAndMax() {
        for (int value : input) {
            updateMaxAndMin(value);
        }
    }

    //Uppdaterar värdet på max och min för varje nytt tal som skickas in till metoden
    private static void updateMaxAndMin(int value) {
        if (value > max)
            max = value;
        if (value < min)
            min = value;
    }

    //Skriver ut resultatet från applikationen (minsta resp. strörsta talen som angetts)
    private static void printResult() {
        System.out.println("Största värdet är " + max + " och minsta värdet är " + min);
        System.out.println();
    }

    //Återställer värdena på max och min till de värden de initialiserats med,
    //dvs. max sätts till minsta möjliga int och min sätts till största möjliga int.
    private static void resetMinAndMax() {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
}
