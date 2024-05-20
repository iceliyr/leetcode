package lyr.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int maxLength=triangle.get(triangle.size()-1).size();
        int[] dp=new int[maxLength];

        for (int i=1; i<maxLength; i++){
            List<Integer> row=triangle.get(i);
            dp[0]+= Math.min(row.get(0), row.get(1) );
            for (int j=1; j<row.size(); j++){
                dp[j]+=Math.min(row.get(j),row.get(j-1));
            }



        }

        int min=Integer.MIN_VALUE;
        for (int i=1; i<maxLength; i++){
            min=Math.min(dp[0],dp[1]);
        }

        return min;
    }
}