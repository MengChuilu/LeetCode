package q038;

class Solution {
    public String countAndSay(int n) {

        String pre = "1";
        for (int i = 1;i < n;i ++) {
            pre = convert(pre);
        }

        return pre;
    }

    private String convert(String pre) {
        StringBuilder sb = new StringBuilder();

        char flag = pre.charAt(0);
        int start = 0;
        for (int i = 1;i < pre.length();i ++) {
            if (flag != pre.charAt(i)) {
                sb.append(i - start);
                sb.append(flag);
                flag = pre.charAt(i);
                start = i;
            }
        }

        sb.append(pre.length() - start);
        sb.append(flag);

        return sb.toString();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.convert("1211");
    }
}