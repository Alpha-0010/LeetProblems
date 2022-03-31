class Solution {
    
    int n;
    String s;
    List<String> res=new ArrayList<>();
    LinkedList<String> segments=new LinkedList<>();
    
    public List<String> restoreIpAddresses(String s) {
        this.s=s;
        n=s.length();
        
        backtrack(-1,3);
        
        return res;
    }
    
    private void backtrack(int prevPos,int dots){
        int maxPos=Math.min(prevPos+4,n-1);
        
        for(int currPos=prevPos+1;currPos<maxPos;currPos++){
            String segment=s.substring(prevPos+1,currPos+1);
            if(valid(segment)){
                segments.add(segment); // Add dot...
                if(dots-1==0){ // If all 3 dots are placed...
                    update_output(currPos);
                }else{
                    backtrack(currPos,dots-1);
                }
                segments.removeLast();
            }
        }
    }
    
    private boolean valid(String segment){
        int m=segment.length();
        if(m>3){
            return false;
        }
        return (segment.charAt(0)!='0') ? Integer.parseInt(segment)<=255: (m==1);
    }
    
    private void update_output(int currPos){
        String segment=s.substring(currPos+1,n);
        
        if(valid(segment)){
            segments.add(segment);
            res.add(String.join(".",segments));
            segments.removeLast();
        }
        
    }
    
}