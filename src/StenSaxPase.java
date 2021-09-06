import java.util.Random;
import java.util.Scanner;

public class StenSaxPase {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    private static int playersScore = 0;
    private static int computersScore = 0;
    private static move playersChoice;
    private static move computersChoice;
    private final static int ROUNDS_TO_WINN = 3;

    private enum move {
        STEN,
        SAX,
        PASE
    }

    //Styr körning av applikationen. Klassens enda metod som kan anropas utifrån.
    public static void run() {
        while (gameIsNotOver()) {
            printMenu();
            getPlayersChoice();
            getComputersChoice();
            printChoiceMessage();
            giveWinnerPoint();
            printScore();
        }
        printWinnerMessage();
        clearScore();
    }

    //Kollar om någon av spelarna har vunnit 3 gånger, dvs. spelet är avgjort.
    private static boolean gameIsNotOver() {
        return playersScore < ROUNDS_TO_WINN && computersScore < ROUNDS_TO_WINN;
    }

    //Skriver ut meny som anger möjliga val för spelaren.
    private static void printMenu() {
        System.out.println("Välj ett av följande alternativ genom att skriva 1, 2 eller 3: ");
        System.out.println("1. Sten");
        System.out.println("2. Sax");
        System.out.println("3. Påse");
        System.out.println(); 
    }

    //Hämtar spelarens val
    private static void getPlayersChoice() {
        int choice = Integer.parseInt(scanner.nextLine());
        playersChoice = getMoveFromChoice(choice);
    }

    //Hämtar datorns val
    private static void getComputersChoice() {
        computersChoice = getMoveFromChoice(random.nextInt(3) + 1);
    }

    //Gör om ett val (i form av en int) till ett val av datatypen Move
    private static move getMoveFromChoice(int choice) {
        return switch (choice) {
            case 1 -> move.STEN;
            case 2 -> move.SAX;
            case 3 -> move.PASE;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    //Skriver ut vilket val som gjorts av datorn resp. spelaren
    private static void printChoiceMessage() {
        System.out.println("Du valde: " + playersChoice);
        System.out.println("Datorn valde: " + computersChoice);
        System.out.println();
    }

    //Ökar rundans vinnares totala poäng (ger ingen poäng om oavgjort)
    private static void giveWinnerPoint() {
        if (!(playersChoice == computersChoice)) {
            if (playerGetPoints())
                playersScore++;
            else
                computersScore++;
        }
    }

    //Avgör vem som vunnit rundan, om olika val gjorts.
    private static boolean playerGetPoints() {
        if (playersChoice == move.STEN)
            return computersChoice != move.PASE;
        else if (playersChoice == move.PASE)
            return computersChoice != move.SAX;
        else
            return computersChoice != move.STEN;
    }

    //Skriver ut poängställningen
    private static void printScore() {
        System.out.println("Antal vinster: ");
        System.out.println("Spelare: " + playersScore);
        System.out.println("Datorn: " + computersScore);
        System.out.println();
    }

    //Skriver ut meddelande då spelat avslutas och vinnare har korats.
    private static void printWinnerMessage() {
        if (playersScore == ROUNDS_TO_WINN) {
            System.out.println("Grattis DU vann!!");
        }
        if (computersScore == ROUNDS_TO_WINN) {
            System.out.println("Datorn vann!");
        }
        System.out.println();
    }

    //Nollställer spelaren och datorns totala poäng, så att applikationen kan köras igen.
    private static void clearScore(){
        playersScore = 0;
        computersScore = 0;
    }






}
