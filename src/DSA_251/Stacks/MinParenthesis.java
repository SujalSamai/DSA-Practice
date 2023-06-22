package DSA_251.Stacks;

import java.util.Stack;

public class MinParenthesis {
    public static void main(String[] args) {
        String pattern=")((()";
        System.out.println(minimumParentheses(pattern));
    }
    public static int minimumParentheses(String pattern) {
        Stack<Character> container= new Stack<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch=pattern.charAt(i);
            if(!container.isEmpty()){
                if(container.peek()=='(' && ch==')'){
                    container.pop();
                }else {
                    container.push(ch);
                }
            }else{
                container.push(ch);
            }

        }

        int count=0;
        while (!container.isEmpty()){
            container.pop();
            count++;
        }
        return count;
    }
}
