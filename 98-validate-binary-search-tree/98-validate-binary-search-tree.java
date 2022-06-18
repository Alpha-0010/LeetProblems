/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root,null,null);
    }
    
    private boolean isBST(TreeNode root,TreeNode maxi,TreeNode mini) {
        if (root == null) {
            return true;
        }
        if ( (maxi!=null && root.val>=maxi.val) || (mini!=null && root.val<=mini.val) ) {
            return false;
        }
        boolean ans1 = isBST(root.left,root,mini);
        boolean ans2 = isBST(root.right,maxi,root);
        return ans1 && ans2;
    }
    
}