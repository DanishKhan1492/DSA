package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};

        System.out.println(containsDuplicate(arr));
    }

    /**
     * Time Complexity: O(n) We are iterating over the array and adding all their elements to HashSet
     * Space Complexity: O(n) we are creating a set with n number of elements
     * */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>(nums.length, 0.75f);
        for(int num: nums){
            numbers.add(num);
        }
        return numbers.size() != nums.length;
    }

    /**
     * Time Complexity: O(n) We are iterating over the array and adding all their elements to HashSet
     * Space Complexity: O(n) we are creating a set with n number of elements
     * */
    public static boolean containsDuplicateSolution1(int[] nums) {
        Set<Integer> numbers = new HashSet<>(nums.length/2, 1f); // Create a set of length half the elements of the array and Set Load Factor to 1. i.e. if full then increase the capacity
        for(int num: nums){
           if(numbers.contains(num)){
               return true;
           }
           numbers.add(num);

           /*
                The same condition can be written as follows
                add method returns a boolean. It will return false the value is already in the set
                if(!numbers.add(num)){
                    return true;
                }
            */

        }
        return numbers.size() != nums.length;
    }

}
