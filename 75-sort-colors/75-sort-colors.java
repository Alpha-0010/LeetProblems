class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length -1 , idx = 0;
        
        while (idx <= right) {
            if (nums[idx] == 0) {
                int temp = nums[idx];
                nums[idx++] = nums[left];
                nums[left++] = temp;
            }else if (nums[idx] == 1) {
                idx++;
            }else {
                int temp = nums[idx];
                nums[idx] = nums[right];
                nums[right--] = temp;
            }
        }
        
    }
}