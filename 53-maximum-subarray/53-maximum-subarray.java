class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        
        for (int num : nums) {
            maxEndingHere += num;
            maxEndingHere = maxEndingHere < num ? num : maxEndingHere;
            maxSoFar = Math.max(maxEndingHere,maxSoFar);
        }
        
        return maxSoFar;
    }
}