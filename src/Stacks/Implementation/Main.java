package Stacks.Implementation;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomStack stack= new CustomStack(6);
        stack.push(24);
        stack.push(35);
        stack.push(16);
        stack.push(9);
        stack.push(57);
        stack.push(89);
        stack.display();

        stack.peek();

        stack.pop();
        stack.pop();
        stack.display();
    }
}
