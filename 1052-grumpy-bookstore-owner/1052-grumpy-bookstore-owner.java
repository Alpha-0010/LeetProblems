class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfiedCustomers = 0;
        for(int i=0;i<customers.length;i++){
            if (grumpy[i]==0) {
                satisfiedCustomers += customers[i];
            }
        }
        int max = 0;
        
        // ...SlidingWindow...
        
        int i=0,j=0;
        int sum = 0;
        while (j<customers.length){
            if (grumpy[j]==1){
                sum+=customers[j];
            }
            // ...Window Shrinking Phase...
            while (i<=j && j-i+1>minutes) {
                if (grumpy[i]==1) {
                    sum-=customers[i];
                }
                i++;
            }
            max=Math.max(max,sum);
            j++;
        }
        
        return satisfiedCustomers + max;
    }
}