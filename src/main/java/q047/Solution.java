package q047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author mengchuilu
 */
public class Solution {

    ////////////////////////////////////////////////////////////////////////////////
//    private Set<List<Integer>> result = new HashSet<>();
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        backTrace(0, nums);
//
//        return new ArrayList<>(result);
//    }
//
//    private void backTrace(int start, int[] nums) {
//        if (start == nums.length - 1) {
//            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
//        }
//
//        for (int i = start; i < nums.length; i ++) {
//            swap(start, i, nums);
//            backTrace(start + 1, nums);
//            swap(start, i, nums);
//        }
//    }
//
//    private void swap(int i, int j, int[] nums) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }
    ////////////////////////////////////////////////////////////////////////////////////////
    private Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> subResult = new ArrayList<>();
        List<Integer> remain = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backTrace(subResult, remain);
        return new ArrayList<>(result);
    }

    private void backTrace(List<Integer> subResult, List<Integer> remain) {

        if (remain.isEmpty()) {
            result.add(new ArrayList<>(subResult));
        }

        for (int i = 0;i < remain.size(); i++) {
            subResult.add(remain.remove(i));
            backTrace(subResult, remain);
            int next = subResult.remove(subResult.size() - 1);
            remain.add(i, next);
        }
    }
}
