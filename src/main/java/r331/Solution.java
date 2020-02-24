package r331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] tmp = Arrays.copyOf(arr,arr.length);
        Arrays.sort(tmp);

        //将元素下标存储到map中
        Map<Integer,Integer> sortedMap = new HashMap<>();
        for (int i = 0, p1 = 0;i < tmp.length;) {
            int num = tmp[i];
            sortedMap.put(num,(p1) + 1);
            p1 ++;
            i ++;
            while (i < tmp.length && num == tmp[i]) {
                i ++;
            }
        }
        for (int i = 0;i < arr.length;i ++) {
            arr[i] = sortedMap.get(arr[i]);
        }
        return arr;
    }
}
