package q055;

public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] result = new boolean[nums.length];
        result[result.length -1] = true;

        for (int i = nums.length - 1;i >= 0;i --) {
            if (!result[i]) {
                continue;
            }

            for (int j = i - 1;j >= 0;j --) {
                if (nums[j] >= i - j) {
                    result[j] = true;
                }
            }
        }

        return result[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{3, 2, 1, 1, 4}));
    }
}