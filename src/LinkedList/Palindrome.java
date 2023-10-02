package LinkedList;
//https://leetcode.com/problems/palindrome-linked-list
public class Palindrome {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode ll= new ListNode(1);
        ll.next = new ListNode(1);
        ll.next.next = new ListNode(2);
        ll.next.next.next= new ListNode(1);
        System.out.println(isPalindrome(ll));
    }
    public static boolean isPalindrome(ListNode head) {
//        ListNode mid= middleNode(head);
//        ListNode headSecond=reverseList(mid);
//        while (head!=null && headSecond!=null){
//            if(head.val!= headSecond.val){
//                return false;
//            }
//            head=head.next;
//            headSecond=headSecond.next;
//        }
//        return true;
        ListNode temp = reverseLL(head);
        return isEqual(head, temp);
    }

    static ListNode reverseList(ListNode head){
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

    static ListNode reverseLL(ListNode head){
        ListNode prev=null, curr=head;
        while (curr!=null){
            ListNode next = new ListNode(curr.val);
            next.next = prev;
            prev = next;
            curr = curr.next;
        }
        return prev;
    }

    static boolean isEqual(ListNode l1, ListNode l2){
        while (l1!=null && l2!=null){
            if(l1.val!=l2.val){
                return false;
            }
            l1=l1.next;
            l2=l2.next;
        }
        return true;
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
