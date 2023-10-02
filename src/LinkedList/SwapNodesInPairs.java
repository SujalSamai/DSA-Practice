package LinkedList;

public class SwapNodesInPairs {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode dummy= new ListNode();
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr!=null && curr.next!=null){
            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;

            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
