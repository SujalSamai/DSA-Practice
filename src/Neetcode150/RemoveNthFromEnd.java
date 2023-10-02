package Neetcode150;

public class RemoveNthFromEnd {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = head.next;
        }

        if (fast==null) return head.next;
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
