package LinkedList;

import java.util.LinkedList;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleElement {
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//    public ListNode middleNode(ListNode head) {
//        ListNode temp=head;
//        int size=0;
//        while (temp!=null){
//            temp=temp.next;
//            size++;
//        }
//        for (int i=0; i<size/2; i++){
//            head=head.next;
//        }
//        return head;
//    }

    //Optimised
    //till fast reaches end of the list, slow will reach half of the list
    ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
