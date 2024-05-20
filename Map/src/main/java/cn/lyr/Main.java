package cn.lyr;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;

        int m= grid.length;
        int n= grid[0].length;
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,m,n,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int m, int n,int r,int c){
        if(r<0||c<0||r>= m||c>=n||grid[r][c]=='0') return;

        grid[r][c]='0';
        dfs(grid,m,n,r-1,c);
        dfs(grid,m,n,r+1,c);
        dfs(grid,r,m,n,c-1);
        dfs(grid,r,m,n,c+1);
    }
}