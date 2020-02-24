package q496;

import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0;i < nums2.length;i ++) {
            while (!stack.isEmpty() && nums2[i] > stack.getFirst()) {
                int subResult = stack.removeFirst();
                cache.put(subResult, nums2[i]);
            }
            stack.addFirst(nums2[i]);
        }
        List<Integer> result = new ArrayList<>();

        for (int i : nums1) {
            result.add(cache.getOrDefault(i, -1));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }
}