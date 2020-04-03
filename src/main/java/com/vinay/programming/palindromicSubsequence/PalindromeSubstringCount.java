package com.vinay.programming.palindromicSubsequence;

public class PalindromeSubstringCount {

    public static void main(String[] args) {
        String st = "abdbca";
        PalindromeSubstringCount palindromeSubstringCount = new PalindromeSubstringCount();
        System.out.println(palindromeSubstringCount.bruteforceMethod(st));
        System.out.println(palindromeSubstringCount.expandAroundCenter(st));
        System.out.println(palindromeSubstringCount.dynamicMethod(st));
    }

    public int dynamicMethod(String st) {
        boolean dp[][] = new boolean[st.length()][st.length()];
        int count = 0;
        for (int i=0;i<st.length();i++) {
            count++;
            dp[i][i] = true;
        }
        for (int start=st.length()-1; start>=0;start--) {
            for (int end= start+1; end < st.length(); end++) {
                if (st.charAt(start) == st.charAt(end)) {
                    if (end-start == 1 || dp[start+1][end-1]) {
                        dp[start][end] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int expandAroundCenter(String st) {
        int count = 0;
        for (int i=0;i<st.length();i++) {
            count += this.expandAroundCenterRecursive(st, i, i);
            count += this.expandAroundCenterRecursive(st, i, i+1);
        }
        return count;

    }

    public int expandAroundCenterRecursive(String st, int start, int end) {
        int count = 0;
        while(end < st.length() && start >= 0 && st.charAt(start) == st.charAt(end)) {
            start--;
            end++;
            count++;
        }
        return count;
    }

    public int bruteforceMethod(String st) {
        int count = 0;
        for(int i=0;i<st.length();i++) {
            for (int j=i; j<st.length(); j++) {
                if (i == j) {
                    count++;
                } else {
                    String stSub = st.substring(i, j+1);
                    if (stSub.equals(new StringBuilder(stSub).reverse().toString()))
                        count++;
                }
            }
        }
        return count;
    }

}
