import java.io.*;
public class dangerousnums{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int t = Integer.parseInt(br.readLine());
        //for(int j=0;j<t;j++){
        int n = Integer.parseInt(br.readLine());
        int to_subt = n%3;
        int temp = n-to_subt;
        System.out.println(temp/3);
        //int count=0;
        //for(int i=1;i<=n;i++){
        //    if(i%3==0){
        //        count++;
        //    }
        //}
        //System.out.println(count);
    } 
}