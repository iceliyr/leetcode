package cn.lyr;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int nums[]={2,0,2,1,1,0};
        solution.sortColors(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int i=0,left=0,right=nums.length-1;
        while(i<=right){
            if(nums[i]==1){
                i++;
                continue;
            }
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                left++;
            }
            if(nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                right--;
            }
        }
    }

    public void nextPermutation(int[] nums) {
        int left=nums.length-2;
        int right=nums.length-1;

        while(left>=0&&nums[left]>=nums[left+1]){
            left--;
        }

        if(left>=0){
            while (right>=0&&nums[right]<=nums[left]){
                right--;
            }
        }

        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]= temp;

        for (int i = left+1,j=nums.length-1; i < j; i++) {
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]= temp;
        }
    }

    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }

        int x1=0,x2=slow;
        while(x1!=x2){
            x1=nums[x1];
            x2=nums[x2];
        }

        return x1;
    }



}