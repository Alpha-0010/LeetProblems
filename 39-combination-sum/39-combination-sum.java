class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums,int target,int s,List<Integer> tempList) {
        /*...Base Case...*/
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (target<0) {
            return ;
        }
        for (int i=s;i<nums.length;i++) {
            tempList.add(nums[i]);
            backtrack(nums,target-nums[i],i,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
    
}