class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=2;i<n+1;i++) {
            if (s.charAt(i-1) != '0') {
                cache[i] = cache[i-1];
            }
            int twoDigit = Integer.parseInt(s.substring(i-2,i));
            if (twoDigit>=10 && twoDigit<=26) {
                cache[i]+=cache[i-2];
            }
        }
        return cache[n];
    }
}