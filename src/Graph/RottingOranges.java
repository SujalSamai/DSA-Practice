package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    //TC- O(n*m)
    public static void main(String[] args) {
        int[][] grid={{2,1,1},{1,1,1},{0,1,2}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid){
        int m=grid.length, n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }else if (grid[i][j]==1){
                    fresh+=1;  //to track how many fresh oranges are pr. initially
                }
            }
        }
        int count=0;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty() && fresh!=0){
            count+=1;  //counting minutes
            int sz= queue.size();
            for (int i = 0; i <sz; i++) {  //for each element in queue, mark its adjacent oranges rotten
                int[] rotten= queue.poll();
                int r=rotten[0], c=rotten[1];
                for (int[] dir:directions){
                    int x=r+dir[0];
                    int y=c+dir[1];
                    if (x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        queue.add(new int[]{x,y});  //add to queue, if it's rotten
                        fresh-=1;
                    }
                }
            }
        }
        return fresh==0? count:-1;
    }

}
