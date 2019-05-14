package q029;

// 很墨迹的一个题目
class Solution {
    public int divide(int dividend, int divisor) {

        int sign = (dividend ^ divisor) >> 31;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        long res = 0;

        while (lDividend >= lDivisor){
            long tmp = lDivisor;
            long i = 1;
            while (lDividend >= tmp){
                lDividend -= tmp;
                res += i;
                i <<= 1;
                tmp <<= 1;
            }
        }
        if (sign == -1) {
            res *= -1;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.divide(1, 1);
    }
}