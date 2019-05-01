package q009;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverse = 0;
        while (x > reverse) {
            int last  = x % 10;
            reverse = reverse * 10 + last;
            x /= 10;
        }

        return reverse == x || reverse / 10 == x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(1100));
    }
}