package algolab.warmup;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Palindrome Should be true: "+ isPalindrome(123454321));
        System.out.println("Palindrome Should be true Optimized way: "+ isPalindromeOptimized(123454321));

        System.out.println("Palindrome Should not be true: "+ isPalindrome(1234514321));
        System.out.println("Palindrome Should not be true Optimized way: "+ isPalindromeOptimized(1234514321));

        System.out.println("Palindrome Should true without converting number to string: "+ isPalindromeInteger(123454321));
        System.out.println("Palindrome Should not be true without converting number to string: "+ isPalindromeInteger(1234514321));
    }

    // Big O =  O(N)
    public static boolean isPalindrome(int number){
        String numberStr = String.valueOf(number);
        StringBuilder reverseNumberStr = new StringBuilder();
        for(int i=numberStr.length() - 1 ; i >= 0; i--){
            reverseNumberStr.append(numberStr.charAt(i));
        }
        return numberStr.equals(reverseNumberStr.toString());
    }

    // Big O = O(N)
    // Though we are iterating only half of the elements but still if we double the array,
    // the half iterations will also get doubled.
    // Big O states: How the performance changes with the increase in the input size
    // Also, Big 0 don't consider constants. So if we write Big O for the below method as O(N/2)
    // It will still be equals to O(N)
    public static boolean isPalindromeOptimized(int number){
        String numberStr = String.valueOf(number);
        int length = numberStr.length();
        // let say number is 121
        // length  = 3

        // Reason for length/2
        // As we are using 2 indexes moving i.e. forward index and backward index
        // At one point both indexes will meet at middle (if length is odd)
        // or both will cross each other (if length is even).
        // In both cases Forward Index is only going till mid
        // So we will iterate till mid.
        for (int i = 0; i <= (length/2); i++) {
            if(numberStr.charAt(i) != numberStr.charAt(length - (i+1))){
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeInteger(int number){
        // dry checking for number 1221
        int numCopy = number;
        int reverse = 0;
        while(numCopy > 0){
            // Iteration 1 : reverse = (0*10) + (1221 % 10) = 0 + 1 = 1
            // Iteration 2: reverse = (1*10) + (122 % 10) = 10 + 2 = 12
            // Iteration 3: reverse = (12*10) + (12 % 10) = 120 + 2 = 122
            // Iteration 3: reverse = (122*10) + (1 % 10) = 1220 + 1 = 1221
            reverse = reverse * 10 + (numCopy % 10);
            // Iteration 1: numCopy = 1221 / 10 = 122
            // Iteration 2: numCopy = 122 / 10 = 12
            // Iteration 3: numCopy = 12 / 10 = 1
            // Iteration 4: numCopy = 1 / 10 = 0 (We can't consider points as number is integer)
            numCopy /= 10;
        }
        return reverse == number;
    }
}
