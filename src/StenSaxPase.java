import java.util.Random;
import java.util.Scanner;

public class StenSaxPase {

    enum move {
        STEN,
        SAX,
        PÅSE
    }

    public static void playGame() {

        int playersScore = 0;
        int computersScore = 0;

        while (playersScore < 3 && computersScore < 3) {
            printMenu();

            move playersChoice = getPlayersChoice(); //spelarens val
            move computersChoice = getComputersChoice(); //datorns val
            choiceMessage(playersChoice, computersChoice);

            if (!(playersChoice == computersChoice)) {
                if (playerGetPoints(playersChoice, computersChoice))
                    playersScore++;
                else
                    computersScore++;
            }
            printScore(playersScore, computersScore);
        }

        winnerMessage(playersScore, computersScore);
    }

    private static void printMenu() {
        System.out.println("Välj ett av följande alternativ genom att skriva 1, 2 eller 3: ");
        System.out.println("1. Sten");
        System.out.println("2. Sax");
        System.out.println("3. Påse");
        System.out.println(""); //Tom rad
    }

    private static move getPlayersChoice() {
        Scanner scanner = new Scanner(System.in);
        return getChoiceFromInt(Integer.parseInt(scanner.nextLine()));
    }

    private static move getComputersChoice() {
        Random random = new Random();
        return getChoiceFromInt(random.nextInt(3) + 1);
    }

    private static move getChoiceFromInt(int choice) {
        return switch (choice) {
            case 1 -> move.STEN;
            case 2 -> move.SAX;
            default -> move.PÅSE;
        };
    }

    private static boolean playerGetPoints(move playersChoice, move computersChoice) {
        boolean playerGetsPoint;

        if (playersChoice == move.STEN)
            playerGetsPoint = computersChoice != move.SAX;
        else if (playersChoice == move.PÅSE)
            playerGetsPoint = computersChoice != move.SAX;
        else
            playerGetsPoint = computersChoice != move.STEN;

        return playerGetsPoint;
    }

    private static void winnerMessage(int playersScore, int computersScore) {
        if (playersScore == 3) {
            System.out.println("Grattis DU vann!!");
        }
        if (computersScore == 3) {
            System.out.println("Datorn vann!");
        }
    }

    private static void choiceMessage(move playersChoice, move computersChoice) {
        System.out.println("Du valde: " + playersChoice);
        System.out.println("Datorn valde: " + computersChoice);
        System.out.println(""); //Tom rad
    }

    private static void printScore(int playersScore, int computersScore) {
        System.out.println("Antal vinster: ");
        System.out.println("Spelare: " + playersScore);
        System.out.println("Datorn: " + computersScore);
        System.out.println(""); //Tom rad
    }


}
