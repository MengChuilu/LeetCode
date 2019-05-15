package q032;

import java.util.Arrays;

class Solution {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 0;i < s.length();i ++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (i > 0 && s.charAt(i - 1) == '(') {
                    int t = 0;
                    if (i > 1) {
                        t = dp[i-2];
                    }
                    dp[i] = t + 2;
                } else if (i > 0 && s.charAt(i - 1) == ')' && i - dp[i - 1] >= 1  && s.charAt(i - dp[i - 1] - 1) == '(') {
                    int t = 0;
                    if (i > dp[i - 1] + 1) {
                        t = dp[i - dp[i - 1] - 2];
                    }
                    dp[i] = t + 2 + dp[i - 1];
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses("(()())");
    }
}