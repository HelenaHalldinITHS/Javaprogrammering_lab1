import java.util.Scanner;

public class MinMax {
    public static void playGame() {
        System.out.println("Välkommen till spelet \"Min Max\"! ");

        int[] result = getInput();
        printResult(result[0],result[1]);

    }

    private static int[] getInput(){
        Scanner scanner = new Scanner(System.in);

        int max = 0; //This value will be overwritten in the first loop bellow.
        int min = 0; //This value will be overwritten in the first loop bellow.
        int temp;

        System.out.println("Skriv 5 tal, tryck enter mellan varje tal: ");

        for (int i = 0; i < 5; i++) {

            temp = Integer.parseInt(scanner.nextLine()); //Get user input as an int

            if (i == 0) {
                min = temp;
                max = temp;
            } else if (temp > max)
                max = temp;
            else if (temp < min)
                min = temp;
        }

        return new int[]{max, min};
    }

    private static void printResult(int max, int min){
        System.out.println("Största värdet är " + max + " och minsta värdet är " + min);
        System.out.println("");
    }

}
