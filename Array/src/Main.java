import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       Solution solution=new Solution();
       String s=solution.intToRoman(1997);
        System.out.println(s);
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last=m+n;
        while (m>0||n>0){
            if(m==0){
                nums1[--last]=nums2[--n];
            } else if (n==0) {
                nums1[--last]=nums1[--m];
            } else if (nums1[m-1]<nums2[n-1]) {
                nums1[--last]=nums2[--n];
            }else {
                nums1[--last]=nums1[--m];
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[k++]=nums[i];
            }
        }
        return k;
    }

    public int removeDuplicates(int[] nums) {
        int k=1;
        int x=1;
        int val=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[k++]=nums[i];
                val=nums[i];
                x=1;
            }else{
                if(x<=2){
                    nums[k++]=nums[i];
                    x++;
                }
            }
        }
        return k;
    }


    public int majorityElement(int[] nums) {
        int res=nums[0];
        int num=1;
        for (int i = 1; i < nums.length; i++) {
            if(res==nums[i]){
                num++;
            } else{
                if(num==0){
                    res=nums[i];
                }else {
                    num--;
                }
            }
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }

    public int hIndex(int[] citations) {
        int length=citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < length; i++) {
            if(citations[i]>=length-i){
                return length-i;
            }
        }
        return 0;
    }

    public int romanToInt(String s) {
        int sum=getValue(s.charAt(0));
        int preNum=0,num=0;
        for (int i = 1; i < s.length(); i++) {
            preNum=getValue(s.charAt(i-1));
            num=getValue((s.charAt(i)));
            if(num>=preNum){
                sum+=num;
            }else {
                sum-=num;
            }
        }
        return sum;
    }
    public int getValue(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:return 0;
        }
    }

    public String intToRoman(int num) {
        int[] arr={1,5,10,50,100,500,1000};
        char[] crr={'I','V','X','L','C','D','M'};
        StringBuilder res=new StringBuilder();
        int index=6;

        while (num>0){
            int x=num/arr[index];
            if(x==0){
                index-=2;
                continue;
            } else if (x<=3) {
                for (int i = 0; i < x; i++) {
                    res.append(crr[index]);
                }
            } else if (x==4) {
                res.append(crr[index]);
                res.append(crr[index+1]);
            } else if (x<=8) {
                res.append(crr[index+1]);
                for (int i = 6; i <= x; i++) {
                    res.append(crr[index]);
                }
            } else if (x==9) {
                res.append(crr[index]);
                res.append(crr[index+2]);
            }
            num=num-x*arr[index];
        }


        return res.toString();
    }

    /**
     58. 最后一个单词的长度
     简单
     相关标签
     相关企业
     给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     单词 是指仅由字母组成、不包含任何空格字符的最大
     子字符串
     。

     示例 1：
     输入：s = "Hello World"
     输出：5
     解释：最后一个单词是“World”，长度为 5。
     示例 2：

     输入：s = "   fly me   to   the moon  "
     输出：4
     解释：最后一个单词是“moon”，长度为 4。
     示例 3：

     输入：s = "luffy is still joyboy"
     输出：6
     解释：最后一个单词是长度为 6 的“joyboy”。

     提示：

     1 <= s.length <= 104
     s 仅有英文字母和空格 ' ' 组成
     s 中至少存在一个单词
     */
    public int lengthOfLastWord(String s) {
        int res=0;
        boolean start=false;
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i)==' '){
                if(start) {
                    break;
                }
            }else{
                start=true;
                res++;
            }
        }
        return res;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c=strs[0].charAt(i);
            boolean can=true;
            for (int j = 0; j <strs.length ; j++) {
                if(strs[j].length()<i+1||c!=strs[j].charAt(i)){
                    can=false;
                    break;
                }
            }
            if(can){
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String reverseWords(String s) {
        List<StringBuilder> list=new ArrayList<>();
        int i =0;
        while (i<s.length()){
            if(s.charAt(i)!=' '){
                StringBuilder stringBuilder=new StringBuilder();
                while (i<s.length()&&s.charAt(i)!=' '){
                    stringBuilder.append(s.charAt(i));
                    i++;
                }
                list.add(stringBuilder);
            }
            i++;
        }
        StringBuilder res=new StringBuilder();
        if(!list.isEmpty()){
            res.append(list.get(list.size()-1));
        }
        for (int j = list.size()-1; j >0; j--) {
            res.append(" ");
            res.append(list.get(j));
        }

        return res.toString();
    }
}