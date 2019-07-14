package q039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> result, int start, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            //System.out.println(start);
            tmp_list.add(candidates[i]);
            //System.out.println(tmp_list);
            backtrack(candidates, target - candidates[i], result, i, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }
}