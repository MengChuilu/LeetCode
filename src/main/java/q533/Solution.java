package q533;

public class Solution {
    public String optimalDivision(int[] nums) {

        if (nums.length == 1) {
            return Integer.toString(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[0]);
        stringBuilder.append("/");
        stringBuilder.append("(");

        for (int i = 1;i < nums.length - 1;i ++) {
            stringBuilder.append(nums[i]);
            stringBuilder.append("/");
        }
        stringBuilder.append(nums[nums.length - 1]);
        stringBuilder.append(")");

        return stringBuilder.toString();
    }
}