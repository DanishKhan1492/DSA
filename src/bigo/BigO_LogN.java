package bigo;

public class BigO_LogN {

    private final int[] array;
    private final int arraySize;

    public BigO_LogN(int size){
        array = new int[size];
        arraySize = size;
    }

    public static void main(String[] args) {
        BigO_LogN bigON = new BigO_LogN(2_000_000);
        bigON.generateArray();
        bigON.binarySearch(50000);

        BigO_LogN bigON1 = new BigO_LogN(3_000_000_0);
        bigON1.generateArray();
        bigON1.binarySearch(50000);

        BigO_LogN bigON2 = new BigO_LogN(2_000_000_00);
        bigON2.generateArray();
        bigON2.binarySearch(50000);
    }

    // O(Log N)
    // For N number of input, the amount of time it takes to process is logarithmic .

    //Value Found at index: 50000
    //Array Size : 2_000_000 Total Operation Took : 21
    //The Time (in Millisecond) it took to find Value: 9

    //Value Found at index: 50000
    //Array Size : 3_000_000_0 Total Operation Took : 25
    //The Time (in Millisecond) it took to find Value: 0

    //Value Found at index: 50000
    //Array Size : 2_000_000_00 Total Operation Took : 27
    //The Time (in Millisecond) it took to find Value: 1

    public void binarySearch(int value){
        long startTime = System.currentTimeMillis();
        int lowerIndex = 0;
        int higherIndex = arraySize - 1;

        int totalOperations = 0;

        while(lowerIndex <= higherIndex){

            int middleIndex = (lowerIndex+higherIndex) / 2;

            if(array[middleIndex] < value){
                lowerIndex = middleIndex + 1;
            }else if(array[middleIndex] > value){
                higherIndex = middleIndex - 1;
            }else {
                System.out.println("Value Found at index: "+ middleIndex);
                lowerIndex = higherIndex + 1;
            }
            totalOperations ++;
        }


        long endTime = System.currentTimeMillis();
        System.out.println("Array Size : "+ arraySize+" Total Operation Took : "+ totalOperations);
        System.out.println("The Time (in Millisecond) it took to find Value: "+ (endTime - startTime));
    }

    public void generateArray(){
        for (int i = 0; i < arraySize; i++) {
            array[i] = i; // Assigning value to array[i] is always O(1) constant time operation.
        }
    }
}
