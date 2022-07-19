package Matrices;

public class ObtainedByRotation {
    public static void main(String[] args) {
        int[][] mat = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};
        System.out.println(findRotation(mat,target));
    }
    public static boolean findRotation(int[][] mat, int[][] target) {
        //rotation can be done only 4 times as 90*4=360, after 4 turns it'll return to original matrix
        for (int i=0; i<4;i++){
            if(same(mat,target)){
                return true;
            }
            mat=rotate(mat);
        }
        return false;
    }
    public static boolean same(int[][] mat, int[][] target){
        if(mat.length==target.length && mat[0].length==target[0].length){
            for (int i=0; i<mat.length;i++){
                for (int j=0; j<mat[0].length;j++){
                    if(mat[i][j]!=target[i][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static int[][] rotate(int[][] mat){
        int row=mat.length;
        int col=mat[0].length;
        int[][] mat2 =new int[row][col];
        //basically row will turn into col and col will turn into row
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                mat2[j][row-i-1]=mat[i][j];
            }
        }
        return mat2;
    }
}
