import java.io.*;
public class tour{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nx = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nx[0]);
        int x = Integer.parseInt(nx[1]);
        String[] ai = br.readLine().trim().split(" ");
        int[] as = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int temp = Integer.parseInt(ai[i]);
            if(Math.abs(x-temp)<min){
                min = Math.abs(x-temp);
            }
            as[i] = temp;
        }
        int ans=-1;
        //int anonmin = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int yo = (Math.abs(as[i]-x))%min;
            if(yo!=0){
                if(yo==1){
                    ans = 1;
                    break;
                }
                min = yo;
            }
        }
        if(ans==-1){
            ans = min;
            System.out.println(ans);
        }
        else{
            System.out.println(ans);
        }
    }
}

