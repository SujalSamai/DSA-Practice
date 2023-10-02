package Neetcode150;

public class ReverseLL {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head){
        if(head==null) return head;
        ListNode temp = null;
        while (head!=null){
            ListNode next = head.next;
            head.next= temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}
