class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        
        // Determine the first element from the right which is less than the next element.
        int idx1 = -1;
        for (int i=nums.length-2;i>=0;i--) {
            if (nums[i] < nums[i+1]) {
                idx1 = i;
                break;
            }
        }
        
        // Determine the element which is greater than nums[idx1] and swap them. 
        int idx2 = -1;
        if (idx1 != -1) {
            for (int i=n-1;i>=0;i--) {
                if (nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }
        }
        
        if (idx1 != -1) {
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
        }
        // Finally sort the array from idx+1
        Arrays.sort(nums,idx1+1,nums.length);
    }
}