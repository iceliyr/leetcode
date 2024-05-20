import java.util.*;

class Solution {
    public int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public  int dfs(TreeNode root){
        if(root==null) return 0;

        int left=dfs(root.left);
        int right=dfs(root.right);
        max=Math.max(left+right+root.val,max);

        int res=Math.max(left,right)+root.val;
        return Math.max(res,0);
    }


}
