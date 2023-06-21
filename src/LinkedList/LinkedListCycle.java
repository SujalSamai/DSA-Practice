package LinkedList;
//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
    private class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
    }
    //fast and slow pointer
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }


    //Length of Linked List Cycle
    //As soon as we get fast==slow,
    //stop the fast pointer there are make the slow pointer traverse the cycle till it reaches fast pointer again
    public int lengthCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode temp=slow;
                int length=0;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
        return 0;
    }
}
