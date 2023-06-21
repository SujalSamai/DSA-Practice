package LinkedList;
//https://leetcode.com/problems/reverse-linked-list

public class ReverseLL {
    private Node head;
    private Node tail;
    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    void reverseRec(Node node){
        //node will reach end
        if(node==tail){
            head=tail;
            return;
        }
        //keep moving next till reaching tail
        reverseRec(node.next);
        //after reaching tail, get out of recursion calls
        tail.next=node;
        tail=node;
        tail.next=null;
    }

    //very imp- in place reversal
    //take 3 pointers-> previous, present, next
    public ListNode reverseList(ListNode head){
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
}
