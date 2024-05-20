package lyr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int nums[][]={{1,2,3},{4,5,6}};
        solution.minPathSum(nums);
    }
}

class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i=2; i<n; i++){
            dp[i]=dp[0]+dp[1];
        }
        return dp[n-1];
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i=0; i<numRows; i++){
            List<Integer> list=new ArrayList<>();
            for (int j=0; j<=i; j++){
                if(j==0||j==i){
                    list.add(1);
                }else {
                    int sum=res.get(i-1).get(j-1)+res.get(j-1).get(j);
                    list.add(sum);
                }
            }
            res.add(list);
        }
        return res;
    }

    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for (int i=1; i<=n; i++){
            int min=Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                min=Math.min(min,dp[i-j*j]);
            }
            dp[i]=min+1;
        }
        return dp[n];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i]=amount+1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = minValue(nums[i],nums[i]*mx,nums[i]*mn);
            minF = maxValue(nums[i],nums[i]*mx,nums[i]*mn);
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public int maxValue(int a,int b,int c){
        a=a>b ? a:b;
        c=a>c ? a:c;
        return c;
    }
    public int minValue(int a, int b, int c){
        a=a<b ? a:b;
        c=a<c ? a:c;
        return c;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0]=1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSum(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i]=grid[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0]=grid[i-1][0]+grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}