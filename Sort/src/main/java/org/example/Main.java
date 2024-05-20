package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] nums={12,9,78,65421,643211};

        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

//        Arrays.sort(numsArr, (x, y) -> {
//            long sx = 10, sy = 10;
//            while (sx <= x) {
//                sx *= 10;
//            }
//            while (sy <= y) {
//                sy *= 10;
//            }
//            return (int) (-sy * x - y + sx * y + x);
//        });
        Arrays.sort(numsArr,(a,b)->{return new Integer(-1);
        });
        for (int i = 0; i < numsArr.length; i++) {
            System.out.println(numsArr[i]);
        }

    }
}

class Solution {
    public String largestNumber(int[] nums) {

        return "1";
    }
}