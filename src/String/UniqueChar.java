package String;
//https://leetcode.com/problems/first-unique-character-in-a-string/
import java.util.HashMap;

public class UniqueChar {
    public static void main(String[] args) {
        String s="loveleetcode";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s){
        HashMap<Character,Boolean> map= new HashMap<>();

        //If map is <Character, Integer>
//        for (char ch: s.toCharArray())
//            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (char ch: s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, false);
            }else{
                map.put(ch, true);
            }
        }
        for (int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
