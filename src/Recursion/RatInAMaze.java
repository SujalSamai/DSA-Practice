package Recursion;
//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {

        int n = 4;
        int[][] a = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};

        ArrayList<String >res=findPath(a, n);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] visArr=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visArr[i][j]=0;
            }
        }
        int[] di={1,0,0,-1};
        int[] dj={0,-1,1,0};

        ArrayList<String> ans=new ArrayList<>();
        if (m[0][0]==1){
            travel(0,0,m,n,ans,"",visArr,di,dj);
        }
        return ans;
    }

    private static void travel(int i, int j, int[][] a, int n, ArrayList<String> ans, String move, int[][] visArr, int[] di, int[] dj) {
        if (i==n-1 && j==n-1){
            ans.add(move);
            return;
        }
        String direction="DLRU";
        for (int ind = 0; ind <4; ind++) {
            int nexti=i+di[ind];
            int nextj=j+dj[ind];
            if (nexti>=0 && nextj>=0 && nexti<n && nextj<n && visArr[nexti][nextj]==0 && a[nexti][nextj]==1){
                visArr[i][j]=1;
                travel(nexti,nextj,a,n,ans,move+direction.charAt(ind),visArr,di,dj);
                visArr[i][j]=0;
            }
        }
    }

    //Another way of doing same thing
    private static void travel2(int i, int j, int a[][], int n, ArrayList < String > ans, String move, int vis[][]) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // downward
        if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
            vis[i][j] = 1;
            travel2(i + 1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
            vis[i][j] = 1;
            travel2(i, j - 1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }

        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
            vis[i][j] = 1;
            travel2(i, j + 1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }

        // upward
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
            vis[i][j] = 1;
            travel2(i - 1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }
}
