class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        
        Arrays.sort(nums);
        
        // 2-Pointer...
        for (int i=0;i<nums.length-1;i++) {
            int left = i+1;
            int right = nums.length-1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }
                if (sum < target) {
                    left++;
                }else {
                    right--;
                }
            }
            
        }
        
        return closestSum;
    }
}