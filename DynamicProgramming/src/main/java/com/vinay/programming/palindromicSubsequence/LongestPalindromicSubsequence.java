package com.vinay.programming.palindromicSubsequence;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String st = "abdcbca";
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        System.out.println(longestPalindromicSubsequence.bruteForceMethod(st, 0, st.length()-1));
        System.out.println(longestPalindromicSubsequence.memorizationMethod(st, 0, st.length()-1, new Integer[st.length()][st.length()]));
        System.out.println(longestPalindromicSubsequence.dynamicMethod(st));
    }

    public int dynamicMethod(String st) {
        int dp[][] = new int[st.length()][st.length()];
        for(int i=0;i<st.length();i++)
            dp[i][i] = 1;

        for (int start=st.length()-1;start>=0;start--) {
            for (int end=start+1;end<st.length();end++) {
                if (st.charAt(start) == st.charAt(end)) {
                    dp[start][end] = 2 + dp[start+1][end-1];
                } else {
                    dp[start][end] = Math.max(dp[start+1][end], dp[start][end-1]);
                }
            }
        }
        return dp[0][st.length()-1];
    }

    public int memorizationMethod(String st, int start, int end, Integer[][] dp) {
        if (start > end)
            return 0;
        if (start == end)
            return 1;
        if (dp[start][end] == null) {
            if (st.charAt(start) == st.charAt(end)){
                dp[start][end] =  2 + this.memorizationMethod(st, start+1, end-1, dp);
            }
            else {
                int value = this.memorizationMethod(st, start+1, end, dp);
                value = Math.max(value, this.memorizationMethod(st, start, end-1, dp));
                dp[start][end] = value;
            }
        }
        return dp[start][end];

    }

    public int bruteForceMethod(String st, int start, int end) {
        if (start > end)
            return 0;
        if (start == end)
            return 1;
        if (st.charAt(start) == st.charAt(end))
            return 2 + this.bruteForceMethod(st, start+1, end-1);
        int value = this.bruteForceMethod(st, start+1, end);
        value = Math.max(value, this.bruteForceMethod(st, start, end-1));
        return value;
    }

}
