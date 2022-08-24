class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        lis[0] = 1;
        int res = 1;
        
        for (int i=1;i<n;i++) {
            lis[i] = 1;
            for (int j=0;j<i;j++) {
                if (nums[i]>nums[j] && 1+lis[j]>lis[i]) {
                    lis[i] = 1+lis[j];
                }
            }
            res = Math.max(res,lis[i]);
        }
        
        return res;
    }
}