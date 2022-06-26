class Solution {
    List<String> result;
    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        backtrack(s,0,new StringBuilder());
        return result;
    }
    
    private void backtrack (String s,int idx,StringBuilder sb) {
        /*...Base Case...*/
        if (idx == s.length()) {
            result.add(sb.toString());
            return;
        }
        char c = s.charAt(idx);
        if (Character.isAlphabetic(c)) {
            sb.append(Character.toLowerCase(c));
            backtrack(s,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(c));
            backtrack(s,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }else {
            sb.append(c);
            backtrack(s,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}