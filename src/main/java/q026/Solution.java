package q026;

// easy还写了好久，但是我记得之前的标准解法不是这样的，但是这个比标准解法好，貌似！！
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int i = 0;
        while (j < nums.length) {
            if (j != 0 && nums[j] == nums[j-1]) {
                j ++;
                continue;
            }

            if (j < nums.length) {
                nums[i] = nums[j++];
                i ++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] in = new int[]{0,0,1,1,1,2,2,3,3,4};
        Solution solution = new Solution();
        solution.removeDuplicates(in);
    }
}