package Arrays;
//https://leetcode.com/problems/pascals-triangle/
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> list= new ArrayList<>();
        for (int i=0; i<numRows; i++){
            List<Integer> temp= new ArrayList<>();
            if(i==0){
                temp.add(1);
            }
            else{
                for (int j=0; j<=i; j++){
                    //adding 1 to first and last index of inner list
                    if(j==0 || j==i){
                        temp.add(1);
                    }else{
                        temp.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                    }
                }
            }
            list.add(temp);
        }
        return list;
    }
}
