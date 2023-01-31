package algolab.warmup;

import java.util.Arrays;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzBuzz(15)));
        System.out.println(Arrays.toString(fizzBuzzWithoutModulusOperator(15)));
    }

    public static String[] fizzBuzz(int n) {
        String[] fizzBuzzResult = new String[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            if (j % 3 == 0 && j % 5 == 0) {
                fizzBuzzResult[i] = "FizzBuzz";
            } else if (j % 3 == 0) {
                fizzBuzzResult[i] = "Fizz";
            } else if (j % 5 == 0) {
                fizzBuzzResult[i] = "Buzz";
            } else {
                fizzBuzzResult[i] = String.valueOf(j);
            }
        }
        return fizzBuzzResult;
    }

    public static String[] fizzBuzzWithoutModulusOperator(int n) {
        String[] fizzBuzzResult = new String[n];
        int fizz = 0;
        int buzz = 0;

        for (int i = 0; i < n; i++) {
            fizz += 1;
            buzz += 1;

            if (fizz == 3 && buzz == 5) {
                fizzBuzzResult[i] = "FizzBuzz";
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                fizzBuzzResult[i] = "Fizz";
                fizz = 0;
            } else if (buzz == 5) {
                fizzBuzzResult[i] = "Buzz";
                buzz = 0;
            } else {
                fizzBuzzResult[i] = String.valueOf(i + 1);
            }
        }

        return fizzBuzzResult;
    }
}
