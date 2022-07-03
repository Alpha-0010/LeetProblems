/*...Dynmaic Programming Problem...*/
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        
        up[0] = 1;
        down[0] = 1;
        
        for (int i=1;i<n;i++) {
            if (nums[i]>nums[i-1]) { // Diff going up...
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }else if (nums[i]<nums[i-1]) { // Diff going down...
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        
        return Math.max(up[n-1],down[n-1]);
    }
}