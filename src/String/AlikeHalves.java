package String;

public class AlikeHalves {
    public static void main(String[] args) {
        String s="textbook";
        System.out.println(halvesAreAlike(s));
    }
    public static boolean halvesAreAlike(String s){
        int count1=0, count2=0;
        for (int i=0; i<s.length()/2; i++){
            if(checkIfVowel(s.charAt(i))){
                count1++;
            }
        }
        for (int i=s.length()/2; i<s.length(); i++){
            if(checkIfVowel(s.charAt(i))){
                count2++;
            }
        }

        return count1==count2;
    }

//        System.out.println("Sujal".indexOf('j')); ans->2
    public static boolean checkIfVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch)!=-1;
    }

}
