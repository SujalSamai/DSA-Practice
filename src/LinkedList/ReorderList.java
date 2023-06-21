package LinkedList;

public class ReorderList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode mid=middleEl(head);
        ListNode hs=reverseList(mid);
        ListNode hf=head;
        while (hf!=null && hs!=null){
            ListNode temp=hf.next;
            hf.next=hs;
            hf=temp;
            temp=hs.next;
            hs.next=hf;
            hs=temp;
        }
        if(hf!=null){
            hf.next=null;
        }
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
    ListNode middleEl(ListNode node){
        ListNode f= node;
        ListNode s= node;
        while (f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
}
