/*...Same as Partition to k equal partition...*/
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null || matchsticks.length<4){
            return false;
        }
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum%4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return dfs(matchsticks,new int[4],0,sum/4);
    }
    
    private boolean dfs (int[] matchsticks,int[] sums,int idx,int target) {
        /*...Base Case...*/
        if (idx == matchsticks.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target) {
                return true;
            }
            return false;
        }
        for (int i=0;i<4;i++) {
            if (sums[i]+matchsticks[idx]>target) {
                continue;
            }
            sums[i] += matchsticks[idx];
            if (dfs(matchsticks,sums,idx+1,target)) {
                return true;
            }
            sums[i] -= matchsticks[idx];
        }
        return false;
    }
    
    private void reverse (int[] matchsticks) {
        int i=0,j=matchsticks.length-1;
        while (i<j) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
            i++;j--;
        } 
    }
    
}
