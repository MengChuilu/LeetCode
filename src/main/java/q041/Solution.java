package q041;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0;i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0;i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

         return nums.length+1;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.firstMissingPositive(new int[]{1,1});
    }
}