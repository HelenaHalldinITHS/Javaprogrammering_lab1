import java.util.Scanner;

//test
public class Meny {

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = selectChoice();

            if (continueApplication(choice))
                runChoice(choice);
            else
                break;
        }
    }

    //Skriver ut menyalternativen
    private static void printMenu() {
        System.out.println("Gör ett av följande val: ");
        System.out.println("1. Upp och Ner");
        System.out.println("2. Min Max");
        System.out.println("3. Sten Sax Påse");
        System.out.println("4. Ordning och reda");
        System.out.println("e. Avsluta");
    }

    //Läser in alternativ från användaren
    private static String selectChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    //Kollar om applikationen ska fortsätta eller inte.
    private static boolean continueApplication(String choice) {
        return !choice.equals("e");
    }

    //Kör den valda applikationen
    private static void runChoice(String choice) {
        switch (choice) {
            case "1" -> UppOchNer.run();
            case "2" -> MinMax.run();
            case "3" -> StenSaxPase.run();
            case "4" -> OrdningOchReda.run();
        }
    }


}
