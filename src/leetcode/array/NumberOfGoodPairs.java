package leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairsSolution1(numbers));
    }


    /**
     * Time Complexity: O(n^2). As we iterate over the array n * n times
     * Space Complexity: O(1)
     * */
    public static int numIdenticalPairs(int[] nums) {
        int pairs = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    pairs++;
                }
            }
        }
        return pairs;
    }


    /**
     * Time Complexity: O(n). As we iterate over the array n times
     * Space Complexity: O(n)
     *
     * In this solution first we find the frequency of the elements in the array.
     * Then using Formula (N(N-1)) / 2 we find the number of pairs.
     * {1,1} = 1
     * {1,1,1} = 3
     * {1,1,1,1,1} = 10 4(4+1)/2 = 20/2 = 10 (4 + 3 + 2 + 1)
     * {1,1,1,1} = 6  3(3+1) / 2 = 12/2 = 6 (3 + 2 + 1)
     * {1,1,1,1,1,1} = 15 5(5+1)/2 = 15 (5 + 4 + 3 + 2 + 1)
     * {1,1,1,1,1,1,1} = 21  6(6+1)/2 = 42/2 = 21 (6 + 5 + 4 + 3 + 2 + 1)
     * */

    public static int numIdenticalPairsSolution1(int[] nums){
        Map<Integer, Integer> frequencies = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity() ,Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        return frequencies.values().stream()
                .filter(integer -> integer >= 2)
                .mapToInt(freq -> ((freq * (freq - 1)) / 2))
                .sum();
    }
}
