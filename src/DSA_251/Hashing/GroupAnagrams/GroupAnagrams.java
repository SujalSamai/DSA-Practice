package DSA_251.Hashing.GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> inputStr, int n) {
        if(inputStr.size()==0 || inputStr==null) return new ArrayList<>();
        HashMap<String, ArrayList<String>> map= new HashMap<>();
        for (String s: inputStr){
            char[] charArr= new char[26];
            for (char c: charArr){
                charArr[c-'a']++;
            }

            String keyStr= String.valueOf(charArr);

            if(!map.containsKey(keyStr)){
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
