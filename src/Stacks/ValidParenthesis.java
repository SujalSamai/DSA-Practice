package Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s="()[{}()]";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        //push all the opening brackets to the stack
        //whenever encounter closing bracket, pop the topmost element and compare if the brackets are opposite
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char c= stack.pop();
                if((s.charAt(i)==')'&& c=='(') ||(s.charAt(i)==']'&& c=='[') || s.charAt(i)=='}'&& c=='{'){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
