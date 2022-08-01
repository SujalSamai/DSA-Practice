package Graph;
//https://leetcode.com/problems/number-of-islands/
public class UniqueIslands {
    public int numIslands(char[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int count=0;
        for (int i=0; i< grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        //marking the current node as visited
        grid[i][j]='2';

        //checking its all four adjacent nodes
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}
