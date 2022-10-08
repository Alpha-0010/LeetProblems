class Solution {
    public int findDuplicate(int[] nums) {
        //...Same as detect cycle in LL, Floyd-Cycle Detection, Tortoise-Hare Technique...
        int n = nums.length;
        if (n == 0 ||  n == 1) {
            return n;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}