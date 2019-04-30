package q008;

import java.math.BigInteger;

class Solution {
    public int myAtoi(String str) {

        int start = 0;
        for (;start < str.length();start ++) {
            if (str.charAt(start) == ' ') {
                continue;
            }
            break;
        }
        if (start == str.length()) {
            return 0;
        }

        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(str.charAt(start ++));
        } while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9');

        if (stringBuilder.toString().equals("+") || stringBuilder.toString().equals("-")) {
            return 0;
        }
        try {
            BigInteger bg = new BigInteger(stringBuilder.toString());
            if (bg.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
                return Integer.MAX_VALUE;
            } else if (bg.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
                return Integer.MIN_VALUE;
            } else {
                return bg.intValue();
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
    }
}