package LinkedList;

public class RotateList {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(k<=0 || head==null || head.next==null){
            return head;
        }

        ListNode last=head;
        int length=1;

        //pointing last to the tail element
        while (last.next!=null){
            last=last.next;
            length++;
        }

        last.next=head;

        //suppose length of list is 6, and k=7, we need to rotate it only one time, there is no use of rotating 7 times
        int rotation=k % length;

        //skip length- rotation elements as they are not needed to be rotated
        int skip=length - rotation;
        ListNode newLast=head;
        //points to the last element which doesn't need to be rotated
        for (int i = 0; i < skip - 1; i++) {
            newLast=newLast.next;
        }

        head=newLast.next;
        newLast.next=null;

        return head;
    }
}
