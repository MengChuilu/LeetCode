package r185;

public class Solution {

    // 蔡勒公式 :  W = [C/4] - 2C + y + [y/4] + [13 * (M+1) / 5] + d - 1  其中 []表示取整
    // https://www.cnblogs.com/faterazer/p/11393521.html
    public String dayOfTheWeek(int day, int month, int year) {
        if(month==1||month==2) {
            month += 12;
            year -- ;
        }
        int iWeek = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;                              //基姆拉尔森计算公式
        String[] result = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        return result[iWeek];
    }
}
