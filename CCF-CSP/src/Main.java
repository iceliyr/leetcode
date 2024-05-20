/*
import java.io.BufferedInputStream;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        int k = scanner.nextInt();

        Map<Integer, Integer> tim = new HashMap<>();
        Map<Integer, Integer> res = new HashMap<>();
        Map<Integer, Integer> flag = new HashMap<>();

        int max = 0;
        for (int i = 0; i < n; ++i) {
            tim.put(i, scanner.nextInt());
            res.put(i, scanner.nextInt());
            max = Math.max(max, tim.get(i));
            flag.put(tim.get(i), flag.getOrDefault(tim.get(i), 0) + res.get(i));
        }
        for (int i = max; i > 0; i--) {
            if (max == k)
                break;
            if (m > flag.get(i)) {
                m = m - flag.get(i);
                flag.put(i - 1, flag.getOrDefault(i - 1, 0) + flag.get(i));
                max--;
            } else
                break;
        }
        System.out.println(max);
    }
}

 */
/* 矩阵运算
 */
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int x;
    public static int a[];
    public static int res=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         n=scanner.nextInt();
         x=scanner.nextInt();
         a=new int[n];
        for (int i=0; i<n; i++){
            a[i]=scanner.nextInt();
        }
        Arrays.sort(a);
        dfs(0,true,0);
        dfs(0,false,0);

        System.out.println(res);

    }
    public static void dfs(int sum,boolean choice,int index){
        if(index==a.length){
            return;
        }
        if(choice) {
            sum+=a[index];
            if (Math.abs(sum - x) < Math.abs(res - x)) {
                res = sum;
            }
        }
            dfs(sum,true,index+1);
            dfs(sum,false,index+1);
    }


}
