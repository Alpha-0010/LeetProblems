class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int cnt=0;
        int i=0,j=0;
        int startIdx=-1,maxLen=Integer.MAX_VALUE;
        int[] hashString=new int[256];
        int[] hashPattern=new int[256];
        for(char c : t.toCharArray()){
            hashPattern[c]++;
        }
        
        while(j<n){
            char c=s.charAt(j);
            hashString[c]++;
            
            if(hashString[c]<=hashPattern[c]){
                cnt++;
            }
            
            if(cnt==m){
                
                // WindowShrinking...
                while(i<=j && hashPattern[s.charAt(i)]<hashString[s.charAt(i)]){
                    hashString[s.charAt(i)]--;
                    i++;
                }
                int currLen=j-i+1;
                if(currLen<maxLen){
                    maxLen=currLen;
                    startIdx=i;
                }
            }
            
            j++;
        }
        
        return startIdx==-1 ? "":s.substring(startIdx,startIdx+maxLen);
    }
}