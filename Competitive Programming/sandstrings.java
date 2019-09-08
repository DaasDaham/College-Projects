import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class sandstrings{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer ans =  new StringBuffer();
        String s = br.readLine();
        int[] arr = new int[s.length()-1];
        int[] dp = new int[s.length()];
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)){
                arr[i] = 1;
            }
            else{
                arr[i] = 0;
            }
            dp[i+1] = dp[i]+arr[i]; 
        }
        int q = Integer.parseInt(br.readLine());
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(dp));
        for(int i=0;i<q;i++){
            String[] k = br.readLine().trim().split(" ");
            int start = Integer.parseInt(k[0])-1;
            int ender = Integer.parseInt(k[1])-1;
            int count=0;
            count = dp[ender]-dp[start];
            if(i==q-1){
                ans.append(count);
            }
            else{
            ans.append(count+"\n");}
        }
        System.out.println(ans);
    }
}
