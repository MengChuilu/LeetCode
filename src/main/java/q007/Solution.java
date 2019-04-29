package q007;

class Solution {
    public int reverse(int x) {

        int result = 0;

        while (x != 0) {
            int last = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            } else if (result == Integer.MAX_VALUE / 10 && last >= 7) {
                return 0;
            } else if (result == Integer.MIN_VALUE / 10 && last <= -8) {
                return 0;
            } else {
                result = result * 10 + last;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-1876987654));
    }
}