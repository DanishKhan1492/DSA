package bigo;

public class BigO_N {

    private final int[] array;
    private final int arraySize;

    public BigO_N(int size){
        array = new int[size];
        arraySize = size;
    }

    public static void main(String[] args) {



        BigO_N bigON = new BigO_N(2_000_000_00);
        bigON.generateArray();
        bigON.linearSearch(20);
        bigON.linearSearch(4_000_000);
        bigON.linearSearch(2_000_000_0);
    }

    // O(N)
    // For N number of input, the amount of time it takes to process is direct proportional .
    // In an array of 2_000_000_00

    // Value Found at index: 20 (Took 20 Iterations to find the value)
    // The Time (in Millisecond) it took to find Value: 6

    // Value Found at index: 4000000 (Took 4 million iterations to find the value)
    // The Time (in Millisecond) it took to find Value: 9

    // Value Found at index: 20000000 (Took 20 million iterations to find the value)
    // The Time (in Millisecond) it took to find Value: 15

    public void linearSearch(int value){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arraySize; i++) {
            if(array[i] == value){
                System.out.println("Value Found at index: "+ i);
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The Time (in Millisecond) it took to find Value: "+ (endTime - startTime));
    }

    public void generateArray(){
        for (int i = 0; i < arraySize; i++) {
            array[i] = i; // Assigning value to array[i] is always O(1) constant time operation.
        }
    }
}