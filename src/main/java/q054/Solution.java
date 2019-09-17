package q054;

/**
 * @author mengchuilu
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] temp = new int[nums.length];

        temp[0] = nums[0];

        for (int i = 1;i < nums.length;i ++) {
            temp[i] = temp[i-1] > 0 ? temp[i-1] + nums[i] : nums[i];
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length; i++) {
            if (result < temp[i]) {
                result = temp[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}