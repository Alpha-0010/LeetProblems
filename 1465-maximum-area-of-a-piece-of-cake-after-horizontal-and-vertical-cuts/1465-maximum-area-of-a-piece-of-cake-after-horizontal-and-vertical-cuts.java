class Solution {
    int MOD = 1000000007;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        
        /*...Sorting Based Problem...*/
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHeight = Math.max(horizontalCuts[0]-0,h-horizontalCuts[n-1]);
        long maxWidth = Math.max(verticalCuts[0]-0,w-verticalCuts[m-1]);
        
        for (int i=1;i<n;i++) {
            maxHeight = Math.max(maxHeight,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        
        for (int i=1;i<m;i++) {
            maxWidth = Math.max(maxWidth,verticalCuts[i]-verticalCuts[i-1]);
        }
        
        return (int)(maxHeight%MOD*maxWidth%MOD)%MOD;
    }
}