class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n=mat.length;
        int[] res=new int[k];
        
        /*...Binary Search + Heap...*/
        PriorityQueue<int[]> pq=new PriorityQueue<>( (a,b) -> a[0]!=b[0] ? b[0]-a[0] : b[1]-a[1] );
        for(int i=0;i<n;i++){
            pq.offer(new int[]{getNumberOfOnes(mat[i]),i});
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        while(pq.size()!=0){
            res[--k]=pq.poll()[1];
        }
        
        return res;
    }
    
    /*...BinarySearch*/
    private int getNumberOfOnes(int[] nums){
        int left=0,right=nums.length-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==1){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    
}