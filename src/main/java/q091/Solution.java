package q091;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {

    public int numDecodings(String s) {

        if (s.charAt(0) == '0') {
            return 0;
        }
        List<Integer> cache = new ArrayList<>();

        if (s.length() == 1) {
            if (s.equals("0")) {
                return 0;
            } else {
                return 1;
            }
        }

        String subString = s.substring(s.length() - 2);
        if (Integer.parseInt(subString) == 0) {
            return 0;
        }
        if (Integer.parseInt(subString) <= 26
                && subString.charAt(1) != '0') {
            cache.add(1);
            cache.add(2);
        } else if (Integer.parseInt(subString) <= 26 && subString.charAt(0) != '0') {
            cache.add(1);
            cache.add(0);
        } else {
            cache.add(1);
            cache.add(1);
        }

        int cacheCount = 2;

        for (int i = s.length() - 3;i >= 0;i --) {
            if (s.charAt(i) == '0' && (s.charAt(i + 1)== 1 || s.charAt(i + 1)== 2)) {
                cache.add(cache.get(cacheCount - 2));
            } else if (s.charAt(i) == '0') {
                return 0;
            } else if (i > 2 || (i == 2 && s.charAt(i + 1) > '6')) {
                cache.add(cacheCount, cache.get(cacheCount - 1));
            } else if (s.charAt(i + 1) == '0') {
                cache.add(cacheCount, cache.get(cacheCount - 1));
            }
            else {
                cache.add(cache.get(cacheCount - 1) + cache.get(cacheCount - 2));
            }
            cacheCount ++;
        }

        return cache.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.numDecodings("12324");
        System.out.println(result);
    }
}