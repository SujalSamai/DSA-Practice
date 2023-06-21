package Matrices;

public class SpecialPosition {
    public static void main(String[] args) {
        int[][] mat={
                {1,0,0},
                {0,0,1},
                {1,0,0}
        };
        System.out.println(numSpecial(mat));
    }
    public static int numSpecial(int[][] mat){
        int[] rowOnes= new int[mat.length];
        int[] colOnes=new int[mat[0].length];

        for (int i=0; i<mat.length; i++){
            int count=0;
            for (int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            rowOnes[i]= count;
        }
        for (int i=0; i<mat[0].length; i++){
            int count=0;
            for (int j=0; j<mat.length; j++){
                if(mat[j][i]==1){
                    count++;
                }
            }
            colOnes[i]= count;
        }

        int ansCount = 0;
        for (int i=0; i<mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==1 && rowOnes[i]==1 && colOnes[j]==1){
                    ansCount++;
                }
            }
        }
        return ansCount;

        //better way to store in rows and cols array
//        int r = mat.length, c = mat[0].length;
//        int []row = new int[r];
//        int []col = new int[c];
//        for(int i=0;i<r;i++){
//            for(int j=0;j<c;j++){
//                if(mat[i][j] == 1){
//                    row[i]++;
//                    col[j]++;
//                }
//            }
//        }

    }
}
