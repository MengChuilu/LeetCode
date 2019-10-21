package q071;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author mengchuilu
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] files = path.split("/");

        Deque<String> queue = new ArrayDeque<>();

        for (String file : files) {
            if (".".equals(file) || file == null || "".equals(file)) {
                continue;
            } else if ("..".equals(file)) {
                if (!queue.isEmpty()) {
                    queue.pop();
                }
            } else {
                queue.push(file);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            result.append("/").append(queue.removeLast());
        }

        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.simplifyPath("/home/");
    }
}