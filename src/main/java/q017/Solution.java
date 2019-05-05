package q017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        letterCombinationsCore(digits, 0, "");
        return result;
    }

    private void letterCombinationsCore(String digits, int index, String str) {
        if (index == digits.length() - 1) {
            for (int i = 0; i < map.get(digits.charAt(index) - '0').length(); i++) {
                result.add(str + map.get(digits.charAt(index) - '0').charAt(i));
            }
        } else {
            for (int i = 0; i < map.get(digits.charAt(index) - '0').length(); i++) {
                letterCombinationsCore(digits, index + 1, str + map.get(digits.charAt(index) - '0').charAt(i));
            }
        }
    }

    private HashMap<Integer, String> map = new HashMap<>();

    {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
}
