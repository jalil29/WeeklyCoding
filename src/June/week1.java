package June;

import java.io.Console;
import java.util.Arrays;

public class week1{
    public static void main(String[] args){
        System.out.println("Challenge 1");
        for (int i = 0; i < 3; i++)
            challenge1(args[i]);
        System.out.println("\n\nChallenge 2");
        challenge2(args[3]);
    }

    private static void challenge1(String input){
        String[] splits = input.split(" ");
        int[] intValues = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            intValues[i] = Integer.parseInt(splits[i]);
        }
        intValues = Arrays.stream(intValues).sorted().toArray();
        System.out.println(intValues[intValues.length - 2]);
    }

    private static void challenge2(String input){
        int sum = 0;

        for (char chara : input.toCharArray()) {
            if (Character.isDigit(chara)) {
                sum += Character.getNumericValue(chara);
            }
        }

        System.out.println(sum);
    }
}
