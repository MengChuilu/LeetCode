package q075;

/**
 * @author mengchuilu
 */
public class Solution {
    public void sortColors(int[] nums) {

        int[] color = new int[3];

        for (int i : nums) {
            color[i] ++;
        }

        int t = 0;
        for (int i = 0;i < 3;i ++) {
            for (int j = 0;j < color[i]; j++) {
                nums[t ++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortColors(new int[]{2,0,2,1,1,0});
    }
}