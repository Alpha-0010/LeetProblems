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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<Integer> stack1=new Stack<>(),stack2=new Stack<>();
        getStack(root1,stack1);
        getStack(root2,stack2);
        List<Integer> res=new ArrayList<>();
        while(stack1.size()!=0 || stack2.size()!=0){
            int elem1=stack1.size()!=0 ? stack1.peek() : Integer.MAX_VALUE;
            int elem2=stack2.size()!=0 ? stack2.peek() : Integer.MAX_VALUE;
            if(elem1<elem2){
                res.add(stack1.pop());
            }else{
                res.add(stack2.pop());
            }
        }
        return res;
    }
    
    private void getStack(TreeNode root,Stack<Integer> stack){
        if(root==null){
            return;
        }
        getStack(root.right,stack);
        stack.push(root.val);
        getStack(root.left,stack);
    }
    
}