package q040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, -1, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void backtrack(int[] candidates, int target, Set<List<Integer>> result, int start, ArrayList<Integer> tmpList) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = start+1; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            //System.out.println(start);
            tmpList.add(candidates[i]);
            //System.out.println(tmpList);
            backtrack(candidates, target - candidates[i], result, i, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}