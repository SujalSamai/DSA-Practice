package String;

import java.util.HashMap;

public class RemoveColoredPieces {
    public static void main(String[] args) {
        String colors = "AAABABB";
        System.out.println(winnerOfGame(colors));
    }
    public static boolean winnerOfGame(String colors){
        HashMap<Character, Integer> map= new HashMap<>();
        map.put('A',0);
        map.put('B',0);

        for(int i=0; i<colors.length(); i++){
            char c = colors.charAt(i);
            int count = 0;

            while (i<colors.length() && colors.charAt(i)==c){
                i++;
                count++;
            }

            map.put(c, map.get(c) + Math.max(0, count-2));
//            System.out.println("A -> "+ map.get('A') + " B -> "+ map.get('B'));
            i--;
        }
        return map.get('A') > map.get('B');
    }
}
