package LinkedList;
//https://leetcode.com/problems/palindrome-linked-list
public class Palindrome {
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid= middleNode(head);
        ListNode headSecond=reverseList(mid);
        while (head!=null && headSecond!=null){
            if(head.val!= headSecond.val){
                return false;
            }
            head=head.next;
            headSecond=headSecond.next;
        }
        return true;
    }

    ListNode reverseList(ListNode head){
        if(head==null){
            return head;
        }
        ListNode prev= null;
        ListNode present= head;
        ListNode nextEl= present.next;

        while (present!=null){
            present.next=prev;
            prev=present;
            present=nextEl;
            if(nextEl!=null){
                nextEl=nextEl.next;
            }
        }
        head=prev;
        return head;
    }
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
