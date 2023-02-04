package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] num = {1,1,2,2,3,4,4,5,5};
        int[] num1 = {1,2,1,2,3,4,3,5,5};
        System.out.println(singleNumber(num));
        System.out.println(singleNumberOptimized(num1));
    }

    /**
     * Simple Solution:
     * We will maintain a Map which will have number and count of its occurrences.
     * Then we will iterate and will pick the one whose value is 1, or we can say whose occurrences is 1.
     *
     * Time Complexity: O(n + n) = O(2n) = O(n) after simplification.
     * Space Complexity: O(n) as we are creating HashMap of length of the array.
     * */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> numWithCount = new HashMap<>();
        for(int num: nums){
            if(numWithCount.containsKey(num)){
                numWithCount.put(num, numWithCount.get(num) + 1);
            }else{
                numWithCount.put(num, 1);
            }
        }

        return numWithCount.entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).findAny().get();
    }


    /**
     * This solution uses XOR operations to find the unique numbers
     * So What XOR is: XOR is a logical operator which results in True only if either of condition is true but not all. (True or False)
     * So what it means that let say we have 2 conditions
     * C1 and C2
     * C1 XOR C2  will return true only if either C1 is true and C2 is false or C2 is true and C1 is false.
     * If both are true or both are false then it will return false.
     * True XOR True = False
     * False XOR False = False
     * True XOR False = True
     * False XOR True = True
     *
     *  So what happens in this case. Basically XOR converts number to Binary under the hood to perform the operation.
     *  so Let say we have an array  = [1,2,1,2,3,4,3,5,5].
     *  As the question say's that it will have all other elements are duplicate except one.
     *  as we assign res = 0; So let dry run the solution step by step.
     *  XOR
     *  0 = 0 0 0
     *  1 = 0 0 1  (First item of array)
     *
     *  res = 0 0 1
     *   2  = 0 1 0
     *
     *  res = 0 1 1
     *   1  = 0 0 1
     *
     *  res = 0 1 0
     *   2  = 0 1 0
     *
     *  res = 0 0 0  (See One's and Zero's are cancelling each other which results in Zero)
     *   3  = 0 1 1
     *
     *  res = 0 1 1
     *   4  = 1 0 0
     *
     *  res = 1 1 1
     *   3  = 0 1 1
     *
     *  res = 1 0 0
     *   5  = 1 0 1
     *
     *  res = 0 0 1
     *   5  = 1 0 1
     *
     *  res = 1 0 0  = 4
     *
     * */
    public static int singleNumberOptimized(int[] nums) {
        int res = 0;
        for(int num: nums){
            res ^= num;
        }
        return res;
    }

}
