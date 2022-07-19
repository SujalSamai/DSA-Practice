package String;
//https://leetcode.com/problems/sorting-the-sentence/
public class SortSentence {
    public static void main(String[] args) {
        String sentence="is2 sentence4 This1 a3";
        System.out.println(sortSentence(sentence));
    }
    public static String sortSentence(String s){
        //split the sentence whenever encounter space and convert it into array
        String[] strArr=s.split(" ");
        String[] arr= new String[strArr.length];

        for (int i=0; i<strArr.length;i++){
            //taking out the number at each index of strArr, at this point it is a character
            char chNum= strArr[i].charAt(strArr[i].length()-1);
            //converting that character to a number, ASCII for 0 is 48
            int num=(int)chNum - 48;
            //as our indexing starting from 0, we are doing num-1, for eg is2 should be at 2nd pos or 1st index
            arr[num-1]=strArr[i].substring(0,strArr[i].length()-1);
        }
        //converting the array to String by joining arr element through putting space between them
        return String.join(" ",arr);
    }
}
