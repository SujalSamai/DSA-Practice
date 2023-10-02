package String;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
    public static String multiply(String num1, String num2) {
        int m=num1.length(), n=num2.length();
        if(m==0 || n==0 || "0".equals(num1) || "0".equals(num2)) return "0";
        if("1".equals(num1)) return num2;
        if("1".equals(num2)) return num1;

        int[] res = new int[m+n];
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int prod = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                prod += res[i+j+1];

                res[i+j+1] = prod%10;
                res[i+j] += prod/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int r : res){
            if(sb.length()==0 && r==0) continue;
            sb.append(r);
        }
        return sb.toString();
    }
}
