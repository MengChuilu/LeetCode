package q012;

public class Solution {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        while (num > 0) {
            for (int i = 0; i < 13; i++) {
                if (num >= values[i]) {
                    result += reps[i];
                    num -= values[i];
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
    }
}