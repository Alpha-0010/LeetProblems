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
    Map<Integer,Integer> map=new HashMap<>();
    int maxDepth=0;
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.val;
        }
        dfs(root,0);
        return map.get(maxDepth);
    }
    private void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        map.put(depth,map.getOrDefault(depth,0)+root.val);
        maxDepth=Math.max(maxDepth,depth);
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}