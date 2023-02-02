package leetcode.array;


public class MergeSortedArray {

    public static void main(String[] args) {
       // int[] nums1 = {1,2,3,0,0,0};
        //int[] nums2 = {4,5,6};
        int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        int[] nums2 = {1,2,2};
        mergeOptimized(nums1, 6,nums2,3);
    }


    /**
     * This solution uses two pointers to merge the arrays
     * pointer1 - For array1
     * pointer2 - For array2
     *
     * As we know the length of array1 is m+n to accommodate array2 values
     * we will create an auxiliary array of length m+n
     * We are traversing till m+n
     *
     * At first iteration we will check value at index pointer1 for array1 is less than value at index pointer2 for array2
     * add the value at index pointer1 of array1 to ith index of auxiliary array and increment pointer2
     * else the value at index pointer2 of array2 is added to ith index of auxiliary array and pointer2 is incremented.
     *
     * we also check a condition if pointer2 value is greater or equal to length of array2, if greater, so we don't have to compare
     * as array2 end reached.
     *
     * pointer1 < m is there not ignore 0  as 0 in middle is counted but 0's at end are ignored.
     *
     * Big O :
     * let call m+n = k where m+n is length of nums1 + nums2 array (0's at end space is not counted as it is there to accommodate 2nd array values)
     * Time complexity: O (k)
     *  O(n+k+k) = O(n+2k)
     *  In Big Simplification we ignore constants and lesser values. As n is less than k
     *  So Big O will O(k)
     *
     * Space Complexity: O(k)
     * */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 && n > 0){
            System.arraycopy(nums2, 0, nums1, 0, nums2.length); // Time Complexity: O(n)
            return;
        }else if(m > 0 && n == 0){
            return;
        }
        int[] resultedArray = new int[nums1.length];
        int pointer1 = 0;
        int pointer2 = 0;
        for(int i = 0; i < nums1.length; i++){
            if(pointer2 >= n || nums1[pointer1] < nums2[pointer2] && pointer1 < m){
                resultedArray[i] = nums1[pointer1];
                pointer1++;
            }else{
                resultedArray[i] = nums2[pointer2];
                pointer2++;
            }
        }
        System.arraycopy(resultedArray, 0, nums1, 0, resultedArray.length); // Time Complexity O(m+n)
    }

    // {1,2,3,0,0,0}
    // {4,5,6}

    /**
     *  This solution also uses 2 pointers
     *  np = num2 array pointer
     *  mp = num1 array pointer
     *  k = total length i.e. length of array 1 + length of array 2 (m+n)
     *
     *  we iterate until array2 pointer is less than 0
     *  we check if value at np index of array2 is greater than value at mp index of array1 then
     *  assign value at kth index of array1. Then decrement k value and np pointer.
     *  otherwise move value at mp index of array1 to kth index of array1 then decrement k value and mp pointer.
     *
     *  let's call m+n = k where m+n is length of nums1 + nums2 array (0's at end space is not counted as it is there to accommodate 2nd array values)
     * Time Complexity: O(k)
     * Space Complexity: O(1) as we are  not using any extra array/space.
     *
     * This solution is optimized in terms of space.
     * */
    public static void mergeOptimized(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        int np = n - 1;
        int mp = m - 1;
        while(np >= 0){
            if(nums2[np] >= nums1[mp]){
                nums1[k] = nums2[np];
                k--;
                np--;
            }else{
                nums1[k] = nums1[mp];
                k--;
                mp--;
            }
        }
    }

}
