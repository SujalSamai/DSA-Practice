package DSA_251.Strings;


public class StringEncoding {
    public static void main(String[] args) {
        String str="abbdcaas";
        System.out.println(encode(str));
    }
    public static String encode(String message) {
        StringBuilder encodedMsg=new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char curr= message.charAt(i);
            int charFreq=1;
            while (i+1<message.length() && message.charAt(i+1)==curr){
                i++;
                charFreq++;
            }
            encodedMsg.append(curr);
            encodedMsg.append(charFreq);
        }
        return encodedMsg.toString();
    }

    //Better Solution
    public static String encode2(String message) {
        StringBuilder encodedMsg=new StringBuilder();
        int count=1;
        for (int i = 0; i < message.length(); i++) {
            if(i<message.length()-1 && message.charAt(i)==message.charAt(i+1)){
                count++;
            }else{
                encodedMsg.append(message.charAt(i));
                encodedMsg.append(count);
                count=1;
            }
        }
        return encodedMsg.toString();
    }
}
