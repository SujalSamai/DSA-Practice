package DSA_251.Strings;

public class BeautifulStrings {
    public static void main(String[] args) {
        String str="01011";
        System.out.println(makeBeautiful(str));
    }
    public static int makeBeautiful(String str){
        int a=0,b=0;
        for(int i=0;i<str.length();i++) {
            if(i%2==0) {
                if(str.charAt(i)=='0') {
                    a++;
                }
                else {
                    b++;
                }
            }
            else {
                if(str.charAt(i)=='1') {
                    a++;
                }
                else {
                    b++;
                }
            }
        }
        return Math.min(a, b);
    }
}
