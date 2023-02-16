package codility;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveNumber {


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        Set<Integer> numbers = new HashSet<>();
        for (int j : arr) {
            numbers.add(j);
        }

        for(int i=1; i < numbers.size() + 1; i++){
            if(!numbers.contains(i)){
                return i;
            }
        }
        return arr.length + 1;
    }

}
