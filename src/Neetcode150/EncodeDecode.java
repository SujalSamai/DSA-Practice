package Neetcode150;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {
        List<String > strs = new ArrayList<>();
        strs.add("Dosa");
        strs.add("I");
        strs.add("Love");
        strs.add("You");
        String encoded = encode(strs);
        System.out.println(encoded);
        System.out.println(decode(encoded));
    }
    public static String encode(List<String> strs){
        StringBuilder encodedStr = new StringBuilder();
        for (String str : strs){
            encodedStr.append(str.length()).append('#').append(str);
        }
        return encodedStr.toString();
    }

    public static List<String> decode(String str){
        List<String> list = new ArrayList<>();
        int i=0;
        while (i<str.length()){
            int j=i;
            //move j till we encounter #, this will help j mark the start of actual string
            //for eg. 5#Hello, i will be on 5, j will reach #
            while (str.charAt(j) != '#') j++;

            //get length of the particular string, it'll get 5 as ans from 5#
            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1 + len;    //increment i till the end of first string = j(1) + 1(#) + len(5)
            list.add(str.substring(j+1, i));    //add the actual string in list (2,7)-> Hello
        }
        return list;
    }
}
