package LinkedList.Implementation.Singly;

public class Main {
    public static void main(String[] args) {
        LL list= new LL();
        list.insertFirst(23);
        list.insertFirst(45);
        list.insertLast(63);
        list.insertLast(90);
        list.insert(17,2);
        list.display();

        list.insertRec(39,2);
        list.display();

//        list.deleteLast();
//        list.deleteFirst();
//        list.delete(1);
//        list.display();

//        System.out.println(list.findNode(23));
    }
}
