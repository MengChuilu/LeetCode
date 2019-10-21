package q066;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mengchuilu
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = Arrays.stream(digits).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        int flag = 1;

        for (int i = list.size() -1; i >= 0;i --) {
            int num = (list.get(i) + flag) % 10;
            flag = (list.get(i) + flag) / 10;
            result.add(0, num);
        }

        if (flag == 0) {
            int[] resu = new int[result.size()];
            for (int i = 0;i < resu.length;i ++) {
                resu[i] = result.get(i);
            }
            return resu;
        }

        int[] resu = new int[result.size() + 1];
        for (int i = 1;i < resu.length;i ++) {
            resu[i] = result.get(i - 1);
        }
        resu[0] = 1;
        return resu;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.plusOne(new int[]{1,2,3});
    }
}