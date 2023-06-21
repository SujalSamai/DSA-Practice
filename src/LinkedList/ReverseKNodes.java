package LinkedList;

public class ReverseKNodes {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //recursion
    public ListNode reverseKGroup(ListNode head, int k) {
        //Single Element
        if(head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode prev  = null;
        ListNode current = head;
        int count = k;

        //Reversing till end of the list or until k nodes
        while(current != null && count > 0) {
            ListNode nextEl = current.next;
            current.next = prev;
            prev = current;
            current = nextEl;
            count--;
        }

        //size of the sublist is less than k, reverse the list again
        if(count > 0) {
            return reverseKGroup(prev, k - count);
        }

        //appending the next sublist to the end of the reversed list
        head.next = reverseKGroup(current, k);
        return prev;
    }

    public ListNode reverseKGroup2(ListNode head, int k){
        ListNode root=new ListNode(0, head);
        ListNode cur=head;
        ListNode prev=root;

        while (cur!=null){
            ListNode tail=cur;
            int count=0;
            while (cur!=null && count<k){
                cur=cur.next;
                count++;
            }

            if(count!=k){
                prev.next=tail;
            }else {
                prev.next=reverse(tail,k);
                prev=tail;
            }
        }
        return root.next;
    }

    private ListNode reverse(ListNode head, int k){
        ListNode prev=null;
        ListNode current=head;
        ListNode next= null;

        while (current!=null && k>0){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            k--;
        }
        head=prev;
        return head;
    }
}
