package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        rres("",n,n,res);
        return res;
    }
    static void rres(String str, int open, int close, List<String> ans){
        if(open==0 && close==0) // base case
            ans.add(str);

        if(open!=0)
            rres(str+"(",open-1,close,ans);

        if(open<close)
            rres(str+")",open,close-1,ans);

    }
}
