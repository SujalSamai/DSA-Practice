package Maths;
//https://www.interviewbit.com/problems/excel-column-number/
//https://leetcode.com/problems/excel-sheet-column-number/
//Given a column title A as appears in an Excel sheet, return its corresponding column number.
public class ExcelCol {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ABC"));
    }
    public static int titleToNumber(String A){
        int n= A.length();
        int res=0;
        for (int i=0; i<n; i++){
            char ch= A.charAt(i);
            res=res*26+ch-'A'+1;
        }
        return res;
    }
}
