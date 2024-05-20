package com.lyr;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k = nums.length >= k ? k : k % nums.length;
        int move[] = new int[k];
        for (int i = nums.length - k, j = 0; j < k; i++, j++) {
            move[j] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = move[i];
        }

    }

    public int[] productExceptSelf(int[] nums) {
        int res[]=new int[nums.length];
        res[0]=1;
        for (int i=1; i<nums.length; i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int right=1;
        for (int i= nums.length-1; i>=0; i--){
            res[i]=res[i-1]*right;
            right*=nums[i];
        }
        return res;
    }

    public int firstMissingPositive(int[] nums) {
        int N=nums.length;
        for (int i = 0; i < N; i++) {
            if(nums[i]<=0){
                nums[i]=N+1;
            }
        }
        for (int i = 0; i < N; i++) {
            int a=Math.abs(nums[i]);
            if(a<=N){
                nums[a-1]=-Math.abs(nums[a-1]);
            }
        }
        for (int i = 0; i < N; i++) {
            if(nums[i]>0){
                return i+1;
            }
        }
        return N+1;
    }

}