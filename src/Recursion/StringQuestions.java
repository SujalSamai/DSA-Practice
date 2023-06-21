package Recursion;

public class StringQuestions {
    public static void main(String[] args) {
//        System.out.println(skip("baccadh"));
//        System.out.println(skipAppNotApple("badhcappledsb"));
        System.out.println(skipString("bdhishdiasdskjd","hish"));
    }

    //skipping a character
    static void skip(String s, String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char c=s.charAt(0);
        if(c=='a'){
            skip(s.substring(1),ans);
        }else{
            skip(s.substring(1),ans+c);
        }
    }

    static String skip(String s){
        if(s.isEmpty()){
            return "";
        }
        char ch=s.charAt(0);
        if (ch == 'a') {
            return skip(s.substring(1));
        }else{
            return ch+skip(s.substring(1));
        }
    }
    //skip Apple
    static String skipString(String s, String sk){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith(sk)){
            return skipString(s.substring(sk.length()),sk);
        }else{
            return s.charAt(0) + skipString(s.substring(1),sk);
        }
    }

    //Skip app when apple is not there
    static String skipAppNotApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("app") && !s.startsWith("apple")){
            return skipAppNotApple(s.substring(3));
        }else{
            return s.charAt(0) + skipAppNotApple(s.substring(1));
        }
    }
}
