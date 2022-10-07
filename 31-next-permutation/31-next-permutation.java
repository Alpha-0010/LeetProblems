class Solution {
    public void nextPermutation(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        
        for (int i=1;i<n;i++) {
            if (nums[i-1] >= nums[i]) {
                cnt++;
            }
        }
        
        // Check if all the elements are in descending order.
        if (cnt == nums.length -1) {
            Arrays.sort(nums);
            return;
        }
        
        // Determine the first element from the right which is less than the next element.
        int idx = -1;
        for (int i=nums.length-2;i>=0;i--) {
            if (nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }
        
        // Swap the element obtained in the previous step with the element just greater than in its right. 
        int s = -1;
        int next = Integer.MAX_VALUE;
        for (int i=idx+1;i<n;i++) {
            if (nums[idx] < nums[i] && nums[i] < next) {
                s = i;
                next = nums[i];
            }
        }
        
        int temp = nums[idx];
        nums[idx] = nums[s];
        nums[s] = temp;
        // Finally sort the array from idx+1
        Arrays.sort(nums,idx+1,nums.length);
    }
}