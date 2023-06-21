package Graph;

public class FloydWarshall {
    public void shortest_distance(int[][] matrix) {
        int n=matrix.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k]==-1 || matrix[k][j]==-1) continue;
                    int checkDist=matrix[i][k]+matrix[k][j];
                    if (matrix[i][j]==-1) matrix[i][j]=checkDist;
                    matrix[i][j]=Math.min(checkDist,matrix[i][j]);
                }
            }
        }
    }
}
