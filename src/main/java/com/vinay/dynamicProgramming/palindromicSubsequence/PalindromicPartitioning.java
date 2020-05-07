package com.vinay.dynamicProgramming.palindromicSubsequence;

public class PalindromicPartitioning {

    public static void main(String[] args) {
        String st = "abdbca";
        PalindromicPartitioning palindromicPartitioning = new PalindromicPartitioning();
        System.out.println(palindromicPartitioning.bruteforceMethod(st, 0, st.length()-1));
        System.out.println(palindromicPartitioning.memorizationMethod(st, 0, st.length()-1, new Boolean[st.length()][st.length()], new Integer[st.length()][st.length()]));

    }

    public int memorizationMethod(String st, int start, int end, Boolean[][] palindromeValues, Integer[][] dp) {
        if (start >= end || this.isPalindromeDynamic(st, start, end, palindromeValues))
            return 0;

        if (dp[start][end] == null) {
            int minCuts = end - start;
            for (int i=start;i<=end;i++) {
                if (this.isPalindromeDynamic(st, start, i, palindromeValues)) {
                    minCuts = Math.min(minCuts, 1 + this.bruteforceMethod(st, i+1, end));
                }
            }
            dp[start][end] = minCuts;
        }
        return dp[start][end];
    }

    private boolean isPalindromeDynamic(String st, int start, int end, Boolean[][] palindromeValues) {
        if (palindromeValues[start][end] == null) {
            int i = start;
            int j = end;
            while (i < j) {
                if (st.charAt(i++) != st.charAt(j--)) {
                    palindromeValues[start][end] = false;
                    return false;
                }
            }
            palindromeValues[start][end] = true;

        }
        return palindromeValues[start][end];
    }

    public int bruteforceMethod(String st, int start, int end) {
        if (start >= end || this.isPalindrome(st, start, end))
            return 0;
        int minCuts = end - start;
        for (int i=start;i<=end;i++) {
            if (isPalindrome(st, start, i)) {
                minCuts = Math.min(minCuts, 1 + this.bruteforceMethod(st, i+1, end));
            }
        }
        return minCuts;
    }

    public boolean isPalindrome(String st, int start, int end) {
        while (start < end) {
            if (st.charAt(start++) != st.charAt(end--))
                return false;
        }
        return true;
    }

}
