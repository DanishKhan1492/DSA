package bigo;

import java.util.Random;

public class BigO_NSquare {

    private final int[] array;
    private final int arraySize;

    public BigO_NSquare(int size){
        array = new int[size];
        arraySize = size;
    }

    public static void main(String[] args) {

        BigO_NSquare bubbleSort20 = new BigO_NSquare(20);
        bubbleSort20.generateRandomArray();
        bubbleSort20.bubbleSort();


        BigO_NSquare bubbleSort4Mill = new BigO_NSquare(4_000_0);
        bubbleSort4Mill.generateRandomArray();
        bubbleSort4Mill.bubbleSort();

        BigO_NSquare bubbleSort20Mill = new BigO_NSquare(2_000_00);
        bubbleSort20Mill.generateRandomArray();
        bubbleSort20Mill.bubbleSort();

    }

    // O(N^2)
    // For N number of input, the amount of time it takes to process is exponential .
    // In below bubble sort we have 2 for loops
    // For every outer loop the inner loop runs n times

    //The amount of Operation Array of Size :20 Took to Sort: 190
    //The Time (in Millisecond) it took to Sort Array of Size 20 : 0

    //The amount of Operation Array of Size :40000 Took to Sort: 799980000
    //The Time (in Millisecond) it took to Sort Array of Size 40000 : 529

    //The amount of Operation Array of Size :200000 Took to Sort: 19999900000
    //The Time (in Millisecond) it took to Sort Array of Size 200000 : 12643

    public void bubbleSort(){
        long startTime = System.currentTimeMillis();
        long operationCounter = 0L;
        for (int i = arraySize - 1 ; i > 0; i--) {
            for(int j = 0; j < i; j++){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                operationCounter++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The amount of Operation Array of Size :"+ arraySize+" Took to Sort: "+ operationCounter);
        System.out.println("The Time (in Millisecond) it took to Sort Array of Size "+ arraySize +" : "+ (endTime - startTime));
    }

    public void generateRandomArray(){
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(); // Assigning value to array[i] is always O(1) constant time operation.
        }
    }
}
