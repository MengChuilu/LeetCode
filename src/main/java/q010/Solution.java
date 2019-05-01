package q010;

class Solution {
//    public int maxArea(int[] height) {
//
//        int max = 0;
//
//        for (int i = 0;i < height.length;i ++) {
//            for (int j = i;j < height.length;j ++) {
//                max = Math.max((j - i) * Math.min(height[i], height[j]), max);
//            }
//        }
//        return max;
//    }

    // 官方比较好的答案
    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;

        int max = 0;

        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));

            if (height[start] > height[end]) {
                end --;
            } else {
                // 如果两边高度相等，则一定不可能只有一条边是最大面的边（要么相等的就是，要不一条不是）
                start ++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
