package LinkedList;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list
public class RemoveNthNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head, slow=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        if (fast==null) return head.next;
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        int n=2;
        System.out.println(removeNthFromEnd(head,n));
    }
}
