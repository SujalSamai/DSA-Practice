package Queue.Implementation;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomQueue queue= new CustomQueue(5);
        queue.insert(20);
        queue.insert(34);
        queue.insert(69);
        queue.insert(12);
        queue.insert(9);
        queue.display();

        queue.remove();
        queue.display();
        System.out.println(queue.front());
    }
}
