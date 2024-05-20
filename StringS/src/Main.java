public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String s="A man, a plan, a canal: Panama";
        boolean b=solution.isPalindrome(s);
        System.out.println(b);
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        char[] crr=new char[s.length()];
        int n=0;
        for (int i = 0; i < crr.length; i++) {
            char c=s.charAt(i);
            if(c<='Z'&&c>='A'){
                crr[n]=Character.toLowerCase(c);
                n++;
            }else if(c<='z'&&c>='a'){
                crr[n]=c;
                n++;
            }else if(c<='9'&&c>='0'){
                crr[n]=c;
                n++;
            }
        }

        for (int i = 0,j=n-1; i < j; i++,j--) {
            if(crr[i]!=crr[j]){
                return false;
            }
        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        int i=0;
        for (int j=0; i<s.length()&& j< t.length(); j++) {
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
        }
        return i==s.length();
    }

    public int[] twoSum(int[] numbers, int target) {
        int n1=0,n2=numbers.length-1;
        while (n1<n2){
           if(numbers[n1]+numbers[n2]==target){
               return new int[]{n1,n2};
           } else if (numbers[n1]+numbers[n2]<target) {
               n1++;
           }else {
               n2--;
           }
        }
        return new int[]{n1,n2};
    }

}