package q022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 卧槽，我就随手一写，不小心按到提交了，就过了。。。。。。
class Solution {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("()");
            return result;
        }

        List<String> temp = generateParenthesis(n-1);
        Set<String> resultSet = new HashSet<>();
        for (String s : temp) {
            for (int i = 0;i < s.length();i ++) {
                resultSet.add(s.substring(0, i) + "()" + s.substring(i));
            }
        }
        return new ArrayList<>(resultSet);
    }
}
