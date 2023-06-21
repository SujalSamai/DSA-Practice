package LinkedList.Implementation.Singly;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

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

    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){     //if it is the first and only el in LL
            tail=head;
        }
        size++;
    }

    public void insertLast(int val){
        Node node= new Node(val);
        if(tail==null){         //if it is the first element
            insertFirst(val);
        }
        tail.next=node;
        tail=node;
        size++;
    }

    public void insert(int val, int index){
        if(index==0){
            insertFirst(val);
        }
        if(index==size){
            insertLast(val);
        }
        Node temp=head;
        for (int i=1; i<index; i++){
            temp=temp.next;
        }
        Node node= new Node(val,temp.next);
        temp.next=node;
        size++;
    }

    public void insertRec(int val, int index){
        head=insertRec(val,index,head);
    }
    private Node insertRec(int val, int index, Node node){
        if(index==0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next=insertRec(val,index-1,node.next);
        return node;
    }

    public Node getNode(int index){
        Node node=head;
        for (int i=0; i<index; i++){
            node=node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int val= head.val;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast= getNode(size-2);
        int val= tail.val;
        tail=secondLast;
        tail.next=null;
        return val;
    }

    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev= getNode(index-1);
        int val= prev.next.val;
        prev.next=prev.next.next;
        return val;
    }

    public int findNode(int value) {
        Node node = head;
        int index=0;
        while (node != null) {
            if (node.val == value) {
                return index;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.val+"-> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

}
