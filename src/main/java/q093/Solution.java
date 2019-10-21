package q093;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return Collections.emptyList();
        }

        backTrace(s, new ArrayList<>());
        return result;
    }

    private void backTrace(String remain, List<Integer> now) {
        if (now.size() > 3 || remain.length() == 0) {
            return;
        }

        if (now.size() == 3 && Long.parseLong(remain) < 256 &&
                (remain.charAt(0) != '0' || remain.length() == 1)) {

            String subResult = "";
            for (int i = 0;i < 3;i ++) {
                subResult = subResult + "." + now.get(i);
            }

            subResult  = subResult + "." + remain;
            subResult = subResult.substring(1);

            result.add(subResult);

            return;
        }

        for (int i = 1;i < remain.length();i ++) {
            String subString = remain.substring(0, i);
            if (Long.parseLong(subString) < 256 &&
                    (subString.charAt(0) != '0' || subString.length() == 1)) {
                remain = remain.substring(i);
                now.add(Integer.parseInt(subString));
                backTrace(remain, now);
                Integer remove = now.remove(now.size() - 1);
                remain = remove + remain;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("010010");

        System.out.println(result);
    }
}