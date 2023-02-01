package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSumOptimized(arr, 18)));
    }

    /**
     * Time Complexity: O(n^2) we are iterating 2 times on n number of elements.
     * Space Complexity: O(1)
     *  The array created with size 2 will always be 2. It does not get effected by the number of elements. So It will be constant space.
     * */
    public static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        for(int i=0; i< nums.length; i++){
            for(int j= 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }
        }
        return indexes;
    }

    /**
     * Time Complexity: O(n) we are iterating only one time on n number of elements.
     * Space Complexity: O(n) : Here we are sacrificing space to achieve O(n) time complexity.
     *
     *  The below solution works by the following formula
     *  Calculate the difference  between target and ith element of array
     *  Check if the difference is there in map, then the indices are current index and index from the map
     *  else add the difference value with index to map (key- value pair)
     *  e.g. arr =  2,7,11,15 target  = 18
     *
     *  Index = 0 then difference = 18 - 2 = 16 -> check 2 present in map ->  not present in map -> add 16 - 0
     *  Index = 1 then difference = 18 - 7 = 11 -> check 7 present in map -> not present in map -> add 11 - 1
     *  Index = 2 then difference = 18 - 11 = 7 -> check 11 present in map -> -> present -> result = [1, 2]  (11 value has index 1 in map)
     * */
    public static int[] twoSumOptimized(int[] nums, int target) {
        int[] indexes = new int[2];
        // A map which will hold the difference between the target and the number on ith index.
        Map<Integer, Integer> targetMap = new HashMap<>();
        for(int i= 0; i< nums.length; i++){
            // Calculate the difference between target and the number on ith index.
            int res = target - nums[i];
            // check if the number on ith index is there in the map. If yes we found our indices.
            if(targetMap.get(nums[i]) != null){
                indexes[0] = targetMap.get(nums[i]);
                indexes[1] = i;
                return indexes;
            }
            targetMap.put(res, i);
        }
        return indexes;
    }
}
