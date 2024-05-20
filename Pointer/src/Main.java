import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int first=0,second=0,third=0;
        for (;first<nums.length;++first){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int target=-nums[first];
            for (second=first+1;second<nums.length-1;++second){
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                third=nums.length-1;
                while (nums[second]+nums[third]>target){
                    third--;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}