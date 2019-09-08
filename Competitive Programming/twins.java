import java.util.*;
import java.io.*;

public class twins{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] val = br.readLine().trim().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i+=1){
            arr[i] = Integer.parseInt(val[i]);
        }
        Arrays.sort(arr);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int count=0;
        int anon_sum=0;
        for(int i=n-1;i>=0;i--){
            anon_sum+=arr[i];
            count+=1;
            sum-=arr[i];
            //System.out.println(anon_sum+" <-anon sum-> "+sum);
            if(anon_sum>sum){
                break;
            }
        }
        System.out.println(count);
    }
}