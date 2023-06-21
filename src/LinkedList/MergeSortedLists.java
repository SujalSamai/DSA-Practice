package LinkedList;
//https://leetcode.com/problems/merge-two-sorted-lists

public class MergeSortedLists {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Basically head is the head for resultant linked list
        ListNode head=new ListNode();
        //tail is for traversing
        ListNode tail=head;

        //till any of the list gets traversed completely
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                tail.next=list1;
                list1=list1.next;
            }
            else {
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }

        //adding the remaining elements from the list which has elements remaining
        if (list1 == null) tail.next = list2;
        else tail.next = list1;
        return head.next;
    }
}
