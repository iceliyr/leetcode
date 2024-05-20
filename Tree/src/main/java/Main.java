public class Main {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        Solution solution=new Solution();
        int pre[]={3,9,20,15,7};
        int in[]={9,3,15,20,7};
        TreeNode node=null;
//        node=solution.buildTree(pre,in);
    }
}
