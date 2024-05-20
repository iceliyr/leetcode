package com.lyr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
      int n[][]={{1,2,3},{4,5,6},{7,8,9}};
      Solution solution=new Solution();
      int a1[][]={
              {1,3,5,7,9},
              {2,4,6,8,10},
              {11,13,15,17,19},
              {12,14,16,18,20},
              {21,22,23,24,25}};
//      solution.searchMatrix(a1,13);
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {

        Set<Integer> row=new HashSet<>();
        Set<Integer> col=new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j=0; j< matrix[0].length; j++){
                if (matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if(row.contains(i)){
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if(col.contains(i)){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
    }



    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0;
        int top=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;
        List<Integer> list=new ArrayList<>();
        int direction=0, i=0, j=0;
         while (left<=right&&top<=bottom){
           list.add(matrix[i][j]);
           switch (direction){
               case 0:
                   if(j==right){
                       direction=1;
                       top++;
                       i++;
                   }else {
                       j++;
                   }
                   break;
               case 1:
                   if(i==bottom){
                       direction=2;
                       right--;
                       j--;
                   }else {
                       i++;
                   }
                   break;
               case 2:
                   if(left==j){
                       direction=3;
                       bottom--;
                       i--;
                   }else {
                       j--;
                   }
                   break;
               case 3:
                   if(top==i){
                       direction=0;
                       left++;
                       j++;
                   }else {
                       i--;
                   }
                   break;
           }
       }
       return list;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = matrix.length-1,j=0; i >=0&&j<matrix[0].length ; i++,j++) {
            if (matrix[i][j]>target) i--;
            else if (matrix[i][j]<target) j++;
            else return true;
        }
        return false;
    }



}