package LinkedList;
//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLL2 {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }

        //skip left-1 elements
        ListNode current= head;
        ListNode prev=null;
        for (int i=0; current!=null && i<left-1; i++){
            prev=current;
            current=current.next;
        }
        ListNode lastEL=prev;
        ListNode newEnd=current;

        //reverse elements between left and right
        ListNode nextEl=current.next;
        for (int i=0; current!=null && i<right-left+1; i++){
            current.next=prev;
            //moving the pointers ahead
            prev=current;
            current=nextEl;
            if(nextEl!=null){
                nextEl=nextEl.next;
            }
        }

        if (lastEL!=null){
            lastEL.next=prev;
        }else{
            head=prev;
        }

        newEnd.next=current;
        return head;
    }

}
