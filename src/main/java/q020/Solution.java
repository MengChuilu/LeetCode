package q020;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0;i < s.length();i ++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}'){
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (s.charAt(i) == ')'){
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValid("()[]{}");
    }
}