class Solution {
    public void wiggleSort(int[] nums) {
        for (int i=0;i<nums.length-1;i++) {
            if (i % 2 == 0 && nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
            }else if (i % 2 == 1 && nums[i] < nums[i+1]){
                // swap
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
    }
}