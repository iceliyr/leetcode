package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    List<List<Integer>> list=new ArrayList<>();
    List<Integer> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        list.add(new ArrayList<>());

        for (int i=1; i<=nums.length; i++){
            dfs(i,-1,nums);
        }
        return  list;
    }

    public void dfs(int length,int index,int[] nums){
        if(res.size()==length){
            list.add(new ArrayList<>(res));
        }
        for (int i=index+1; i<nums.length; i++){
            res.add(nums[i]);
            dfs(length,i,nums);
            res.remove(res.size()-1);
        }

    }

    public int singleNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }

    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1;
        for (int i=0; i<right; i++){
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
}