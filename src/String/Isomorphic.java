package String;

import java.util.HashMap;

public class Isomorphic {
    public static void main(String[] args) {
        String str1 = "pijthbsfy";
        String str2 = "fvladzpbf";
        System.out.println(areIsomorphic(str1,str2));
    }
    public static boolean areIsomorphic(String str1,String str2) {
        //mapping characters from both the strings
        HashMap<Character,Character> map= new HashMap<>();
        if(str1.length()!=str2.length()){
            return false;
        }
        for (int i=0; i<str1.length();i++){
            char c1=str1.charAt(i);
            char c2=str2.charAt(i);
            //value of c1 should be equal to c2
            if(map.containsKey(c1)){
                if(map.get(c1)!=c2) return false;
            }else {
                //if map doesn't have key but the value is present in the map, that means the value is associated with two keys which is wrong
                //for eg: here 'f' in str2 is associated with 'p' and 'y' in str1
                if(map.containsValue(c2)){
                    return false;
                }
                map.put(c1,c2);
            }
        }
        return true;
    }
}
