package com.vinay.programming.palindromicSubsequence;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String st = "abddbca";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.bruteForceMethod(st, 0, st.length()-1));
        System.out.println(longestPalindromicSubstring.memorizationMethod(st, 0, st.length()-1, new Integer[st.length()][st.length()]));
        System.out.println(longestPalindromicSubstring.dynamicMethod(st));
    }

    public int dynamicMethod(String st) {
        boolean dp[][] = new boolean[st.length()][st.length()];
        for (int i=0;i<st.length();i++)
            dp[i][i] = true;

        int maxLength = 0;
        for (int start=st.length()-1; start>=0; start--) {
            for (int end=start+1; end<st.length();end++) {
                if (st.charAt(start) == st.charAt(end)) {
                    if (end - start == 1 || dp[start+1][end-1]) {
                        maxLength = Math.max(end-start+1, maxLength);
                        dp[start][end] = true;
                    }
                }
            }
        }
        return maxLength;
    }

    public int memorizationMethod(String st, int start, int end, Integer[][] dp) {
        if (start > end)
            return 0;
        if (start == end)
            return 1;
        if (dp[start][end] == null) {
            if (st.charAt(start) == st.charAt(end)) {
                int value = this.bruteForceMethod(st, start+1, end-1);
                if (value == end-start-1){
                    dp[start][end] = value+2;
                    return dp[start][end];
                }
            }
            int value = Math.max(this.bruteForceMethod(st, start, end-1), this.bruteForceMethod(st, start+1, end));
            dp[start][end] = value;
        }
        return dp[start][end];
    }

    public int bruteForceMethod(String st, int start, int end) {
        if (start > end)
            return 0;
        if (start == end)
            return 1;
        if (st.charAt(start) == st.charAt(end)) {
            int value = this.bruteForceMethod(st, start+1, end-1);
            if (value == end-start-1)
                return value+2;
        }
        int value = Math.max(this.bruteForceMethod(st, start, end-1), this.bruteForceMethod(st, start+1, end));
        return value;
    }

}
