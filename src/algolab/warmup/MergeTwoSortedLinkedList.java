package algolab.warmup;

import org.w3c.dom.NodeList;

import java.util.List;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode l2 = new ListNode(3, new ListNode(5, new ListNode(7)));

        mergeTwoLists(l1, l2);
    }

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
