import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.partitionLabels("eaaaabaaec");
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int last=nums[0];
        int i=0;
        for (; i<=last && i<nums.length; i++){
            last= Math.max(i+nums[i],last);
        }
        return i == nums.length - 1;
    }

    public int jump(int[] nums) {
        int end=0;
        int max=0;
        int step=0;
        for (int i=0; i<nums.length-1; i++){
            max=Math.max(max,i+nums[i]);
            if(i==end){
                step++;
                end=max;
            }
        }
        return step;
    }

    public List<Integer> partitionLabels(String s) {
        int p[]=new int[26];
        for (int i = 0; i < s.length(); i++) {
            p[s.charAt(i)-'a']=i;
        }
        List<Integer> list=new ArrayList<Integer>();
        int begin=-1;
        int last=p[s.charAt(0)-'a'];
        for (int i = 0; i < s.length(); i++) {
            if(i==last){
                list.add(last-begin);
                begin=last;
            }
            last=Math.max(last,p[s.charAt(i)-'a']);
        }
        return list;
    }
}
