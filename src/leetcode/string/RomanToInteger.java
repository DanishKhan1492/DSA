package leetcode.string;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCDXL"));
    }

    public static int romanToInt(String s) {
        int convertedValue = 0;
        int previousNumber = 0;
        for (int i= 0; i< s.length(); i++) {
            int currentNumber = romanCharToNumber(s.charAt(i));
            if (currentNumber > previousNumber) {
                convertedValue = (convertedValue - previousNumber) + (currentNumber - previousNumber);
            } else {
                convertedValue += currentNumber;
            }
            previousNumber = currentNumber;
        }
        return convertedValue;
    }

    private static Integer romanCharToNumber(char romanChar){
        return switch (romanChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1;
        };
    }

}
