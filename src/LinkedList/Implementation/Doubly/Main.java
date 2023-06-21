package LinkedList.Implementation.Doubly;

public class Main {
    public static void main(String[] args) {
        DLL list= new DLL();
        list.insertFirst(34);
        list.insertFirst(23);
        list.insertLast(45);
        list.insertLast(78);

        list.display();
        list.reverse();
    }
}
