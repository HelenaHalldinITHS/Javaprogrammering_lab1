import java.util.Arrays;
import java.util.Scanner;

public class OrdningOchReda {

    public static void playGame() {
        System.out.println("Välkommen till spelet \"Ordning och reda\"! ");
        int[] result = getInput();
        Arrays.sort(result);
        int sum = sumOfSecondGreatestAndSecondLeast(result);

        System.out.println("Summan av det näst största respektive näst minsta talet är: " + sum);
        System.out.println(" ");
    }

    //Get input
    private static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv 5 tal, separerade med mellanslag: ");
        String input = scanner.nextLine();
        return changeFormOfInput(input);
    }

    //Change form of input
    private static int[] changeFormOfInput(String input) {
        int[] result = new int[5]; //5 numbers is only valid amount.
        StringBuilder tempString = new StringBuilder();
        char temp;
        int j = 0;
        input.trim(); //sting always ends with a number

        for (int i = 0; i < input.length(); i++) {
            temp = input.charAt(i);

            if (temp != ' ') {
                tempString.append(temp);
            } else {
                result[j] = Integer.parseInt(tempString.toString());
                tempString = new StringBuilder(); //nollställ
                j++;
            }

            if (i==(input.length()-1)){ //last round we want to "flush" all data in tempString.
                result[j]=Integer.parseInt(tempString.toString());
            }
        }

        return result;
    }

    
    private static int sumOfSecondGreatestAndSecondLeast(int[] results) {
        return (results[1] + results[results.length - 1]);
    }
}
