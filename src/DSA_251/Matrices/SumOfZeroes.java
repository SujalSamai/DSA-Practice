package DSA_251.Matrices;

import java.util.ArrayList;

public class SumOfZeroes {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat= new ArrayList<>();
        mat.add(new ArrayList<>());
        mat.add(new ArrayList<>());
        mat.get(0).add(1);
        mat.get(0).add(0);
        mat.get(1).add(0);
        mat.get(1).add(1);
        System.out.println(coverageOfMatrix(mat));
    }
    public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {
        int count=0;
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(0).size(); j++) {
                if(mat.get(i).get(j)==0){
                    if(j>0 && mat.get(i).get(j-1)==1) count++;
                    if(j<mat.get(0).size()-1 && mat.get(i).get(j+1)==1) count++;
                    if(i>0 && mat.get(i-1).get(j)==1) count++;
                    if(i<mat.size()-1 && mat.get(i+1).get(j)==1) count++;
                }
            }
        }

        return count;
    }
}
