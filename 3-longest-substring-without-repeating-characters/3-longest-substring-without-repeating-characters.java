class Solution {
    public int lengthOfLongestSubstring(String s) {
        // ...Sliding Window Problem-->Type-1...
        int i=0,j=0;
        int res=0;
        int[] hash=new int[256];
        while(j<s.length()){
            hash[s.charAt(j)]++;
            // ...Window Shrinking phase...
            while(i<=j && hash[s.charAt(j)]>1){
                hash[s.charAt(i)]--;
                i++;
            }
            int len=j-i+1;
            res=Math.max(res,len);
            j++;
        }
        return res;
    }
}