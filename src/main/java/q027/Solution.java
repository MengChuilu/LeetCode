package q027;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            while (nums[i] == val) {
                i ++;
            }

            nums[j++] = nums[i++];
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeElement(new int[]{3,2,2,3}, 3);
    }
}