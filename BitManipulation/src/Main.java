import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
//        solution.addBinary("asdd","asdfws");

    }
}

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res=new StringBuilder();
        char[] as=a.toCharArray(),bs=b.toCharArray();
        int i=a.length()-1,j=b.length()-1;
        int x=0;
        while (i>=0||j>=0){
           x+= i>=0 ? as[i]-'0':0;
           x+= j>=0 ? bs[j]-'0':0;
           if(x==0){
               res.append('0');
               x=0;
           } else if (x==1) {
               res.append('1');
               x=0;
           } else if (x==2) {
               res.append('0');
               x=1;
           }else {
               res.append('1');
               x=1;
           }
           i--;
           j--;
        }
        if(x==1) res.append('1');
        return res.reverse().toString();
    }

    public int reverseBits(int n) {
        int res=0;
        for (int i = 0; n>0&&i < 32; i++) {
            res = res | ((n&1)<<(32-i));
            n=n>>>1;
        }
        return res;
    }


    public int hammingWeight(int n) {
        int nums=0;
        while(n!=0){
            if((n&1)==1){
                nums++;
            }
            n>>>=1;
        }
        return nums;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    public int rangeBitwiseAnd(int left, int right) {
        int res=0;
        for (int i = left; i <=right ; i++) {
            res&=i;
        }
        return res;
    }


}