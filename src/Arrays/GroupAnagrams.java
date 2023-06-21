package Arrays;
//https://leetcode.com/problems/group-anagrams/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] list={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(list));
    }
    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs==null || strs.length==0) return new ArrayList<>();
        HashMap<String, List<String>> map=new HashMap<>();
        for (String s: strs){
            //count characters for each string and put it in arr
            char[] charArr= new char[26];
            for (char c: s.toCharArray()){
                charArr[c-'a']++;
            }
            //converting our charArr to a form of string
            String keyStr=String.valueOf(charArr);

            //if our map doesn't contain keyStr, add it to map's key and add an arraylist to map's value
            if(!map.containsKey(keyStr)){
                map.put(keyStr, new ArrayList<>());
            }
            //if our map contain keyStr, add it to map's value
            map.get(keyStr).add(s);
        }
        //return all the values from the map
        return new ArrayList<>(map.values());
    }
}
