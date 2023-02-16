package algolab.warmup;

import java.util.Arrays;

public class ArrayOfPermutation {

    public static void main(String[] args) {
        int[] arr = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArrayTest(arr)));
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * */
    public static int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = nums[nums[i]];
        }
        return result;
    }


    /**
     * This solution uses Euclid's Division Algorithm.
     * Euclid Algorithm states that for positive 2 integers let say a and b there exists q and r such that it satisfies
     * a = bq + r condition.  q = quotient and r = remainder
     * In below solution if we consider
     * arr[index] = r
     * quotient = n where n = arr.lenght
     * b = arr[arr[index]] % n
     * so in our case it will become.
     * arr[index] = arr[index] + (arr[arr[index]] % n) * n
     *
     * To get the real number we divide the arr every number by length of the array.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * */
    public static int[] buildArrayTest(int[] nums) {
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i] + n* (nums[nums[i]] % n);
        }
        for(int i=0; i<n ; i++){
            nums[i] /= n;
        }
        return nums;
    }

}
