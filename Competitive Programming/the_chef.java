import java.io.*;
import java.util.*;

public class the_chef{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().trim().split(" ");
        String[] strarr = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nq[0]);
        int m = Integer.parseInt(nq[1]);
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(strarr[i]);
        }
        long[][] dp = new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        for(int diff=0;diff<n;diff++){
            int i=0;
            int j=0;
            while(i+diff<n){
                j = i+diff;
                if(diff<m){
                    dp[i][j] = maxi(i, j, arr);
                    /*for(int l1=0;l1<n;l1++){
                        for(int l2=0;l2<n;l2++){
                            System.out.print(dp[l1][l2]+"  ");
                        }
                        System.out.println();
                    }*/
                }
                else{
                for(int k=i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
                }}
                i++; 
            }
        }
        System.out.println(dp[0][n-1]);
    }

    public static long maxi(int i, int j, int[] arr){
        long maximum = Long.MIN_VALUE;
        for(int kj=i;kj<=j;kj++){
            if(arr[kj]>maximum){
                maximum = arr[kj];
            }
        }
        return maximum;
    }
}