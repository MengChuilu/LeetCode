package r124;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int longestWPI(int[] hours) {

        int n = hours.length;
        int[] score = new int[n];
        for (int i = 0;i < n;i ++) {
            if (hours[i] > 8) {
                score[i] = 1;
            } else {
                score[i] = -1;
            }
        }
        int[] presum = new int[n + 1];
        for (int i = 1;i <= n;i ++) {
            presum[i] = presum[i - 1] + score[i - 1];
        }

        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0;i <= n;i ++) {
            if (stack.isEmpty() || presum[stack.peekLast()] > presum[i]) {
                stack.addLast(i);
            }
        }
        int i = n;
        while (i > ans) {
            while (!stack.isEmpty() && presum[stack.peekLast()] < presum[i]) {
                ans = Math.max(ans, i - stack.peekLast());
                stack.removeLast();
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.longestWPI(new int[]{6,6,6,6,6,6,6,6});
        System.out.println(result);
    }
}
