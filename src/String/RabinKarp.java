package String;
//https://practice.geeksforgeeks.org/problems/31272eef104840f7430ad9fd1d43b434a4b9596b/1
import java.util.ArrayList;

public class RabinKarp {
    ArrayList<Integer> search(String pat, String S) {
        int patHash=0;
        int winHash=0;
        ArrayList<Integer> ans=new ArrayList<>();
        int n=S.length();
        int m=pat.length();
        for (int i = 0; i < m; i++) {
            patHash+= pat.charAt(i)-'a';
            winHash+=S.charAt(i)-'a';
        }

        if (patHash==winHash && pat.equals(S.substring(0,m))){
            ans.add(1);
        }

        for (int i = m; i < n; i++) {
            winHash-=S.charAt(i-m)-'a';
            winHash+=S.charAt(i)-'a';

            if (patHash==winHash && pat.equals(S.substring(i-m+1, i+1))){
                ans.add(i-m+2);
            }
        }
        if (ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
}
