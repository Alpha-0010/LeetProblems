class Solution {
    public String longestPalindrome(String s) {
        int idx=0,maxLen=0;
        
        // Odd Length Palindrome
        
        for(int mid=0;mid<s.length();mid++){
            int left=mid,right=mid;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                int currLen=right-left+1;
                if(currLen>maxLen){
                    maxLen=currLen;
                    idx=left;
                }
                left--;
                right++;
            }
        }
        
        // Even Length Palindrome
        
        for(int mid=0;mid<s.length()-1;mid++){
            int left=mid,right=mid+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                int currLen=right-left+1;
                if(currLen>maxLen){
                    maxLen=currLen;
                    idx=left;
                }
                left--;
                right++;
            }
        }
        return s.substring(idx,maxLen+idx);
    }
}