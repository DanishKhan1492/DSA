package algolab.warmup;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        //int[][] accounts = {{1,2,3}, {3,2,1}};
        int[][] accounts = {{1,5}, {7,3}, {3,5}};
        System.out.println(maximumWealth(accounts));
    }

    /**
     * Time Complexity: O(m*n) where m is the number of Customers and n is the number of Banks
     * Space Complexity: O(1) we are creating a constant space i.e. maxWealth variable.
     * */
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int wealth = 0;
            for (int i : account) {
                wealth += i;
            }
            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }
}
