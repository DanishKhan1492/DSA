package codility;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class CodilityEmumba {

    public static void main(String[] args) {
        int[] arr = {10,-10,-1,-1,10};
        System.out.println(minimumRelocations(arr));
        System.out.println(stringDivisibleBy3("0081"));
    }

    public static int stringDivisibleBy3(String s){

        if(s.matches("(^0{1,9}$)")){
            return 0;
        }

        int count = 0;
        Set<String> alreadyProcessed = new HashSet<>();
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            StringBuilder sCopy = new StringBuilder(s);
            for(int j = 0; j < 10; j++){
                sCopy.setCharAt(i, String.valueOf(j).charAt(0));
                int sCopyInt = Integer.parseInt(sCopy.toString());
                int sum = 0;
                while(sCopyInt > 0){
                    sum += sCopyInt % 10;
                    sCopyInt/=10;
                }
                if(sum % 3 == 0 && !alreadyProcessed.contains(sCopy.toString())){
                    alreadyProcessed.add(sCopy.toString());
                    count++;
                }
            }
        }
        return count;
    }


    public static int minimumRelocations(int[] arr){
        int minimumRelocations = 0;
        int total = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for(int num : arr){
            priorityQueue.add(num);
            total += num;
            if(total < 0){
                minimumRelocations++;
                Integer removedNum = priorityQueue.poll();
                if(removedNum != null){
                    total -= removedNum;
                }
            }

        }

        return minimumRelocations;
    }
}
