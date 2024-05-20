package lyr;

public class Main {
    public static void main(String[] args) {

        int a[]={5,7,7,8,8,10};
        Solution solution=new Solution();
        solution.searchRange(a,8);


    }
}

class Solution {

    public int searchInsert(int[] nums, int target) {
       int left=0,right=nums.length-1;
       while (left<right){
          int mid=(left+right)/2;
          if(target>nums[mid]){
              left=mid;
          } else if (target<nums[mid]) {
              right=mid;
          }else {
              return mid;
          }
       }
       return left;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        for (int i = 0; i < matrix.length-1; i++) {
            if(target<=matrix[i][matrix[i].length-1]){
                for (int j = 0; j < matrix[i].length-1; j++) {
                    if(target==matrix[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[]{-1,-1};

        int low=0,high=nums.length-1;
        while (low<high&&nums[low]!=target) {
            int mid=(high-low)/2+low;
            if(nums[mid]<target){
                low=mid;
            } else if(nums[mid]>target){
                high=mid;
            }else {
                low++;
            }
        }

        if(nums[low]!=target) return res;
        res[0]=low;
       low=0;
       high=nums.length-1;
        while (low<high) {
            int mid=(high-low)/2+low;
            if(nums[mid]<target){
                low=mid;
            } else if(nums[mid]>target){
                high=mid;
            }else {
                high++;
            }
        }

        res[1]=low;
        return res;
    }

    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        if(nums.length==1) return nums[0]==target ? 0:-1;

        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(right-left)/2+left;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[0]<=mid){
                if(nums[0]<=target&&target<nums[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }else {
                if(target>nums[mid]&&target<nums[nums.length-1]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }

            }
        }
        return -1;
    }


    public int findMin(int[] nums) {
        int minNum=nums[0];
        int l=0, r=nums.length-1,n=r;
        while (l<=r){
            int mid=(l+r)/2;
            minNum=Math.min(minNum,nums[mid]);
            if(nums[mid]>=nums[0]){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return minNum;
    }


}
