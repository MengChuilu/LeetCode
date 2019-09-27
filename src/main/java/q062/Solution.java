package q062;

import java.math.BigInteger;

public class Solution {
//    int[][] cache = new int[101][101];
//    public int uniquePaths(int m, int n) {
//        if (m == 1 || n == 1) {
//            return 1;
//        }
//        if (cache[m][n] != 0) {
//            return cache[m][n];
//        }
//        int result = 0;
//
//        for (int i = 1;i <= m;i ++) {
//            result += uniquePaths(i, n - 1);
//        }
//        cache[m][n] = result;
//        return result;
//    }
//

    //////////////////////  排列组合，从n+m-2和操作之中全出n-1个向下的就可可以了，
    // 实际就是C(n-1, m+n-2)
    public int uniquePaths(int m, int n) {
        BigInteger multiply = factional(n + m - 2 - (n - 1)).multiply(factional(n - 1));
        return factional(n+m-2).divide(multiply).intValue();
    }

    private BigInteger factional(int n) {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 1;i <= n;i ++) {
            result = BigInteger.valueOf(i).multiply(result);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(36, 7));
    }
}