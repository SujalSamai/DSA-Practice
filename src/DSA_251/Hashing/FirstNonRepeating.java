package DSA_251.Hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String str="aDcadhc";
        System.out.println(firstNonRepeatingCharacter(str));
    }
    public static char firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Traverse the string
        for (char c : str.toCharArray()) {
            if (freq.get(c) == 1) {
                return c;
            }
        }
        return str.charAt(0);
    }
}
