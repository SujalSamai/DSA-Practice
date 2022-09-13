package DP;
//https://leetcode.com/problems/longest-string-chain/
import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int n= words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp=new int[n];
        int maxi=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (checkPossible(words[i],words[j]) && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            if (dp[i]>maxi){
                maxi=dp[i];
            }
        }
        return maxi+1;
    }

    private boolean checkPossible(String w1, String w2) {
        if (w1.length()!=w2.length()+1) return false;
        int first=0,second=0;
        while (first<w1.length()){
            if (second<w2.length() && w1.charAt(first)==w2.charAt(second)){
                first++; second++;
            }else{
                first++;
            }
        }
        if (first==w1.length() && second==w2.length()){
            return true;
        }
        else return false;
    }
}
