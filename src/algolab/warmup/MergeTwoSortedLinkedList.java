package algolab.warmup;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode l2 = new ListNode(3, new ListNode(5, new ListNode(7)));

       mergeTwoLists(l1, l2);
       mergeRecursion(l1, l2);
    }


    /**
     * This solution requires 2 Objects
     * 1. For Merged List
     * 2. Tail of the mergedList
     *
     * We iterate on unitl one of the LinkedList exhaust or tail.next reaches to null
     * We check if list2 value is less than list1 value then assign list2 to the tail Object created for mergedList, and increment list2 tail.
     * same goes for list1.
     *
     * As MergedList.next = tail so after one of the list next reaches null we will have our sorted merged list
     *
     * Time Complexity = O(m+n) as we are iterating on every item of both linkedLists.
     * Space Complexity = O(1) As we are just creating two objects. As for any number of input parameters we will always create 2 objects in Heap.
     * So we call it Constant Space Complexity.
     * */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // n1 -> 2 -> next -> n2 -> 4 -> next -> n3 -> 6 -> null
        // n4 -> 3 -> next -> n5 -> 5 -> next -> n6 -> 7 -> null

        ListNode mergedList = new ListNode();
        ListNode tail = mergedList;

        while(true){
            if(list2 == null){
                tail.next = list1;
                break;
            }

            if(list1 == null){
                tail.next = list2;
                break;
            }

            if(list2.val < list1.val){
                tail.next = list2;
                list2 = list2.next;
            }else{
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        return mergedList.next;
    }


    /**
     * Time Complexity: O(m+n) as all elements are iterated in recursive calls.
     * Space Complexity: O(m+n) (m+n) time functions call stack
     *
     * */

    public static ListNode mergeRecursion(ListNode list1, ListNode list2){
        // Base Conditions either of one reaches null return the other list
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        // Check if list1 value is less than list2 value if yes
        // assign list1.next to recursive call pass next object of list1 and list 2
        // return list1

        // otherwise do the same for list2.


        /*
         e.g.
         // n1 -> 2 -> next -> n2 -> 4 -> next -> n3 -> 6 -> null
         // n4 -> 3 -> next -> n5 -> 5 -> next -> n6 -> 7 -> null

            2 < 3 -> true
            On Stack we will have
            ----------------------------------------------------------------
            n2 -> 4 -> next -> n3 -> 6 -> null
            n4 -> 3 -> next -> n5 -> 5 -> next -> n6 -> 7 -> null

            4 < 3 -> false
            In next recursive call we will have
            ----------------------------------------------------------------
            n2 -> 4 -> next -> n3 -> 6 -> null
            n5 -> 5 -> next -> n6 -> 7 -> null

            Same will go on util Base condition met.
            so list 2 will be returned
            n6 -> 7 -> null
            as we are assigning list1.next so list1 at n-1 function call stack will be
             -> 6 -> 7 -> null
             here list2.next will be returned as
             5 -> 6 -> 7 -> null
             .
             .
             .
         */

        if(list1.val < list2.val){
            list1.next = mergeRecursion(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeRecursion(list1, list2.next);
            return list2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
