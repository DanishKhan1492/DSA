package algolab.warmup;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(iterativeFib(4));
    }

    // 5
    // 0, 1, 1, 2, 3


    /**
     * Recursive Solution:
     *
     * TimeComplexity: O(2^n) F(n) = F(n-1) + F(n-2)
     * SpaceComplexity: O(n)
     * */
    public static int fib(int n) {
        if(n <= 1) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    /**
     * Time complexity: O(n) (We are iterating from N till 1)
     * Space complexity: O(1) We are using only constant space i.e. int vars.
     * */
    public static int iterativeFib(int n) {
        if(n <= 1) {
            return n;
        }
        int first  = 0;
        int second = 1;

        for(int i = n; i > 1; i--){
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
