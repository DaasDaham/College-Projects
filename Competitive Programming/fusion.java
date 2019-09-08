import java.io.BufferedReader;
import java.util.Iterator;
import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class fusion{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] k_t = br.readLine().trim().split(" ");
        int powers[] = new int[n];
        for(int i=0;i<n;i++){
            int to_add = Integer.parseInt(k_t[i]);
            powers[i] = to_add;
        }
        long[][] dp = new long[n][n];
        for(int diff=1;diff<n;diff++){
            int i=0;
            int j=0;
            while(i+diff<n){
                j = i+diff;
                for(int k=i;k<j;k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k+1][j]);
                }
                dp[i][j]+=sum(i, j, powers);
                i++;
            }
        }
        System.out.println(dp[0][n-1]);
    }

    public static long sum(int i, int j, int[] arr){
        long count = 0;
        for(int iter=i;iter<=j;iter++){
            count+=arr[iter];
        }   
        return count;
    }
}