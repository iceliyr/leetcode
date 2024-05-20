package org.example;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String s="A man, a plan, a canal: Panama";
        solution.isPalindrome(s);
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        char[] crr=new char[s.length()];
        int n=0;
        for (int i = 0; i < crr.length; i++) {
            char c=s.charAt(i);
            if(c<='Z'&&c>='A'){
                crr[i]=Character.toLowerCase(c);
                n++;
            }else if(c<='z'&&c>='a'){
                crr[i]=c;
                n++;
            }
        }
        for (int i = 0; i < crr.length; i++) {
            System.out.print(crr[i]);
        }
        for (int i = 0,j=n-1; i < j; i++,j--) {
            if(crr[i]!=crr[j]){
                return false;
            }
        }
        return true;
    }

}