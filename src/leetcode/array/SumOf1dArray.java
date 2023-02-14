package leetcode.array;

import java.util.Arrays;

public class SumOf1dArray {
    public static void main(String[] args) {
        int[] array = {1,1,1,1,1};
        System.out.println(Arrays.toString(runningSum(array)));
    }

    public static int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
