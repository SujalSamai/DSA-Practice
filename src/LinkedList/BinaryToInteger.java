package LinkedList;

import java.util.LinkedList;

public class BinaryToInteger {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
         int size=0;
         int res=0;
         while (temp!=null){
             size++;
             temp=temp.next;
         }
         temp=head;
         while(temp!=null){
             size--;
             res=res+ (temp.val*(int)(Math.pow(2,size)));
             temp=temp.next;
         }
         return res;
    }
}
