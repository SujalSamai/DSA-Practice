package String;
//https://leetcode.com/problems/integer-to-roman/
import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRoman {
    public static void main(String[] args) {
        int num=37;
        System.out.println(intToRoman(num));
    }
    /*We used linked HashMap because we have to traverse map in a order (so we used the order or insertion as the desired order).
    We can save space by using 1 linked hashmap insted of 2 arrays.
    We can save time complexity using 1 linked hashmap because it can be traversed in O(n) while, if we use 2d array, it would take O(n^2).*/
    public static String intToRoman(int num) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        //adding key, value pairs to hashmap from top to bottom order
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");

        // if you are facing problem understanding how below code, please learn methods of travering in map.
        // we can also use a iterator, but it will cost us extra space.
        // we can not use forEach lambda expression here, because we have to make changes to the num, which cant be final.
        for(Map.Entry<Integer, String> i : map.entrySet()) {
            while(num >= i.getKey()) {
                sb.append(i.getValue());
                num -= i.getKey();
            }
        }

        // because we have to return string, so converting stringBuilde into string.
        return sb.toString();
    }
}
