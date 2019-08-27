package q043;

class Solution {
    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        String result = "0";

        for(int i = 0; i < length1; i ++) {
            String subResult = "0";
            for (int j = 0; j < num1.charAt(i) - '0'; j ++) {
                subResult = add(subResult, num2);
            }

            result = add(result, subResult);
            result += "0";
        }

        return deductZero(result.substring(0, result.length() - 1));
    }

    /**
     * 两数加法
     * @param num1
     * @param num2
     * @return
     */
    private String add(String num1, String num2) {

        StringBuilder num1Revers = new StringBuilder(num1).reverse();
        StringBuilder num2Revers = new StringBuilder(num2).reverse();

        StringBuilder result = new StringBuilder();
        int max = Math.max(num1Revers.length(), num2Revers.length());
        int flag = 0;

        for (int i = 0; i < max; i ++) {
            int subNum1 = i >= num1Revers.length() ? 0 : num1Revers.charAt(i) - '0';
            int subNum2 = i >= num2Revers.length() ? 0 : num2Revers.charAt(i) - '0';

            int subResult = (subNum1 + subNum2 + flag);
            flag = subResult / 10;
            result.append((char) (subResult % 10 + '0'));
        }

        if (flag == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    /**
     * 去掉前面的0
     * @param s
     * @return
     */
    private String deductZero(String s) {
        int begin = s.length() - 1;
        for (int i = 0;i < s.length() - 1; i ++) {
            if (s.charAt(i) != '0') {
                begin  = i;
                break;
            }
        }

        return s.substring(begin);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.multiply("9133", "0");
        System.out.println(s);
    }

}