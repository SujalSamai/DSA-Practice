package Neetcode150;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else{
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if ((c=='(' && s.charAt(i)==')') || (c=='[' && s.charAt(i)==']') || (c=='{' && s.charAt(i)=='}')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
