import java.util.Arrays;
import java.util.Scanner;

public class OrdningOchReda {

    public static void run() {
        System.out.println("Välkommen till spelet \"Ordning och reda\"! ");

        int[] result = getInput();
        endMessage(result);

    }

    //Get input
    private static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv 5 tal, separerade med mellanslag: ");
        String input = scanner.nextLine();
        return changeFormOfInput(input);
    }

    //Change form of input from string to int[]
    private static int[] changeFormOfInput(String input) {
        int[] result = new int[5]; //5 numbers is only valid amount.
        StringBuilder tempString = new StringBuilder();
        char temp;
        int j = 0;

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
        Arrays.sort(results);
        return (results[1] + results[results.length - 1]);
    }

    private static boolean isArraySorted(int[] array){
        int[] originalArray = array.clone(); //original array
        Arrays.sort(array); //array is now sorted

        for (int i = 0; i < array.length; i++) {
            if (array[i] != originalArray[i])
                return false;
        }
        return true;
    }

    private static void endMessage(int[] numbers ){
        boolean isSorted = isArraySorted(numbers); //also sorts array
        int sum = sumOfSecondGreatestAndSecondLeast(numbers);

        System.out.println("Min value: " + numbers[0]);
        System.out.println("2Min value: " + numbers[1]);
        System.out.println("2Max value: " + numbers[numbers.length-2]);
        System.out.println("Max value: " + numbers[numbers.length-1]);
        System.out.println("I ordning: " + isSorted);
        System.out.println("Summa: " + sum );
        System.out.println(" ");
    }
}
