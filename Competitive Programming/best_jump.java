import java.io.*;
public class best_jump{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nm = br.readLine().trim().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(nm[i]);
        }
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                count++;
                max = arr[i];
            }
        }
        //count++;
        System.out.println(count);
    }
}