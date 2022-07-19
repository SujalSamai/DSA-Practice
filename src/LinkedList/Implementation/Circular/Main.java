package LinkedList.Implementation.Circular;

public class Main {
    public static void main(String[] args) {
        CLL list= new CLL();
        list.insert(34);
        list.insert(21);
        list.insert(45);
        list.insert(19);
        list.display();
        list.delete(21);
        list.display();
    }
}
