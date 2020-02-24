package q467;

import java.util.Arrays;

public class Solution {
    public int findSubstringInWraproundString(String p) {

        int[] result = new int[26];
        int subStrStartIndex = 1;
        for (int i = 0;i < p.length();i ++) {
            if (i != 0 && (p.charAt(i -1) == p.charAt(i) - 1 || (p.charAt(i -1) == 'z' && p.charAt(i) == 'a'))) {
                subStrStartIndex ++;
            } else {
                subStrStartIndex = 1;
            }
            int maxSubResult = Math.max(result[p.charAt(i) - 'a'], subStrStartIndex);
            result[p.charAt(i) - 'a'] = maxSubResult;
        }

        System.out.println(Arrays.toString(result));
        return Arrays.stream(result).sum();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findSubstringInWraproundString("zab");
        System.out.println(result);
    }
}