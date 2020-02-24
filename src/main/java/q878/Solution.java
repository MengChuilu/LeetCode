package q878;

public class Solution {
    public int nthMagicalNumber(int N, int a, int b) {

        int lcm = (a * b) / gcd(a, b);
        long end = Long.MAX_VALUE;
        long start = 0;
        // 这里有个小技巧，这个样写二分法可以返回最小的符合条件的，对这个问题，避免结果再次验证
        while (start < end) {
            long half = (end - start) / 2 + start;
            if (half / a - half / lcm + half / b < N) {
                start = half + 1;
            } else {
                end = half;
            }
        }

        return Long.valueOf(start % 1_000_000_007).intValue();
    }

    // get a gcd with two integer
    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.nthMagicalNumber(1, 2, 3);
        System.out.println(result);
    }


    /**
     * 二分法的四种写法
     *
     1、最常见的一种,适用于数组只有符合结果只有一个的
    while (start < end) {
        int half = (end - start) / 2 + start;

        if (condition) {
            start = half + 1;
        } else if (condition) {
            end == half - 1;
        } else {
            return half;
        }

     2、多个结果的（一定会连在一起，否则不能用二分法）

     这种会返回最小值（比如1,2,3，4,5,6,7,8,9,10；需要找大于5，小于7的值，这种会返回5）
    while (start < end) {
        int half = (end - start) / 2 + start;

        if (condition) {
            start = half + 1;
        } else if (condition) {
            end == half;
        }
    }
     这种会返回最小值（比如1,2,3，4,5,6,7,8,9,10；需要找大于5，小于7的值，这种会返回7）
     while (start < end) {
        int half = (end - start) / 2 + start;

        if (condition) {
            start = half;
        } else if (condition) {
            end == half - 1;
        }
     }
     */

}