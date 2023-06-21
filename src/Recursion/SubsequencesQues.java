package Recursion;

import java.util.ArrayList;

//Subset-> Non- adjacent Collection of elements from a list, order of elements can't change
//Subarray-> Adjacent collection of elements from an array
//Note- Subset is used for arrays and Subsequence is for Strings, but they are basically same
public class SubsequencesQues {
    public static void main(String[] args) {
//        subseq("","abc");
//        System.out.println(subSeqSet("","abc"));
//        permutations("","abc");
//        System.out.println(permutationsList("","abc"));
        System.out.println(permutationsCount("","abcd"));
    }

    //subset-> pattern is take some elements and add them, later remove the same elements and add them
    static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch= up.charAt(0);
        subseq(p+ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    static ArrayList<String > subSeqSet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String > list= new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=subSeqSet(p+ch, up.substring(1));
        ArrayList<String > right= subSeqSet(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    //permutations -> rearranging the given string
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=up.charAt(0);
        for (int i=0; i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            permutations(f+ch+s,up.substring(1));
        }
    }
    static ArrayList<String> permutationsList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch=up.charAt(0);
        ArrayList<String > ans= new ArrayList<>();
        for (int i=0; i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            ans.addAll(permutationsList(f+ch+s,up.substring(1)));
        }
        return ans;
    }

    static int permutationsCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        char ch=up.charAt(0);
        int count=0;
        for (int i=0; i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            count=count+permutationsCount(f+ch+s,up.substring(1));
        }
        return count;
    }
}
